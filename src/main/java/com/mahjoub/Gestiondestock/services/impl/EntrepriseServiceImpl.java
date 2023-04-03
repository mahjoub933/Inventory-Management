package com.mahjoub.Gestiondestock.services.impl;

import com.mahjoub.Gestiondestock.DAO.Entreprise;
import com.mahjoub.Gestiondestock.DTO.EntrepriseDto;
import com.mahjoub.Gestiondestock.DTO.RoleDto;
import com.mahjoub.Gestiondestock.DTO.UtilisateurDto;
import com.mahjoub.Gestiondestock.Exceptions.EntityNotFoundException;
import com.mahjoub.Gestiondestock.Exceptions.ErrorCode;
import com.mahjoub.Gestiondestock.Exceptions.InvalidEntityException;

import com.mahjoub.Gestiondestock.Repository.EntrepriseRepository;
import com.mahjoub.Gestiondestock.Repository.RoleRepository;
import com.mahjoub.Gestiondestock.services.EntrepriseService;
import com.mahjoub.Gestiondestock.services.UtilisateurService;
import com.mahjoub.Gestiondestock.validators.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional(rollbackOn = Exception.class)
@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;
    private UtilisateurService utilisateurService;
    private RoleRepository roleRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, UtilisateurService utilisateurService
            , RoleRepository roleRepository) {
        this.entrepriseRepository = entrepriseRepository;
        this.utilisateurService = utilisateurService;
        this.roleRepository = roleRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
           List <String>errors= EntrepriseValidator.validate(entrepriseDto);
           if(!errors.isEmpty()){
               log.error("l'entreprise n'est pas valide",entrepriseDto);
               throw new InvalidEntityException
                       ("l'entreprise n'est pas valide", ErrorCode.ENTREPRISE_NOT_VALID,errors);
           }


        EntrepriseDto saveEntreprise =    EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto)));

           UtilisateurDto utilisateurDto = fromEntreprise(saveEntreprise);
           UtilisateurDto saveUser = utilisateurService.save(utilisateurDto);

           RoleDto role = RoleDto.builder()
                   .nomR("Admin")
                   .utilisateur(saveUser)
                   .build();
           roleRepository.save(RoleDto.toEntity(role));
           return saveEntreprise;
    }

    private UtilisateurDto fromEntreprise(EntrepriseDto entrepriseDto){
         return UtilisateurDto.builder().
         adresse(entrepriseDto.getAdresse())
                 .nomU(entrepriseDto.getNomE())
                 .prenomU(entrepriseDto.getCodefiscal())
                 .emailU(entrepriseDto.getEmailE())
                 .motdepasse(generatePassword())
                 .entreprise(entrepriseDto)
                 .photoU(entrepriseDto.getPhotoE())
                 .build();
    }

    private String generatePassword(){
           return "mahjoub@token";

    }

    @Override
    public EntrepriseDto findById(Integer id) {
           if(id==null){
               log.error("l'id de l'entreprise est nulle");
               return null;
           }
        Optional<Entreprise>entreprise=entrepriseRepository.findById(id);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(()->new EntityNotFoundException
                ("l'entreprise de L'ID"+id+"n'a pas trouvé dans la BDD",ErrorCode.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findByCodeEntreprise(String code) {
           if(!StringUtils.hasLength(code)){
               log.error("le code de l'entreprise n'a pas valide");
           }
           Optional<Entreprise>entreprise=entrepriseRepository.findByCodeEntreprise(code);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(()->new EntityNotFoundException("l'entreprise de code"+code+"n'a pas trouvé dans la BDD", ErrorCode.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteEntreprise(Integer id) {
        if(id==null){
            log.error("l'id est nulle");
            return;}
           entrepriseRepository.deleteById(id);

    }
    
}
