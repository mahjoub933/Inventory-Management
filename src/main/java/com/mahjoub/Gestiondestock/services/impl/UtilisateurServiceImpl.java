package com.mahjoub.Gestiondestock.services.impl;

import com.mahjoub.Gestiondestock.DAO.Utilisateur;
import com.mahjoub.Gestiondestock.DTO.UtilisateurDto;
import com.mahjoub.Gestiondestock.Exceptions.EntityNotFoundException;
import com.mahjoub.Gestiondestock.Exceptions.ErrorCode;
import com.mahjoub.Gestiondestock.Exceptions.InvalidEntityException;
import com.mahjoub.Gestiondestock.Repository.UtilisateurRepository;
import com.mahjoub.Gestiondestock.services.UtilisateurService;
import com.mahjoub.Gestiondestock.validators.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String>errors= UtilisateurValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("l'utilisateur n'est pas valide",dto);
            throw new InvalidEntityException("l'utilisateur n'est pas valide", ErrorCode.UTILISATEUR_NOT_VALID,errors);
        }
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(dto)));
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if(id==null){
            log.error("l'id est nulle");
            return null;
        }
        Optional<Utilisateur> user=utilisateurRepository.findById(id);
        return Optional.of(UtilisateurDto.fromEntity(user.get()))
                .orElseThrow(()->new EntityNotFoundException
                        ("user de l'ID"+id+"n'a pas trouvé dans la BDD",ErrorCode.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public UtilisateurDto findByCodeClient(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("le code n'est pas valide");
        }
        Optional<Utilisateur> utilisateur=utilisateurRepository.findByCodeUser(code);
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get()))
                .orElseThrow(()->new EntityNotFoundException("user du code "+code+"n'a pas trouvé dans la BDD",ErrorCode.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream().map(UtilisateurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer id) {
        if(id==null){
            log.error("l'ID client est nulle");
            return;
        }
        utilisateurRepository.deleteById(id);

    }
    @Override
    public UtilisateurDto findByEmailU(String email){
        return utilisateurRepository.findUtilisateurByEmailU(email).map(UtilisateurDto::fromEntity)
                .orElseThrow(()->
                         new EntityNotFoundException("l'email "+ email + "n'existe pas dans la BDD",ErrorCode.UTILISATEUR_NOT_FOUND));
    }
}
