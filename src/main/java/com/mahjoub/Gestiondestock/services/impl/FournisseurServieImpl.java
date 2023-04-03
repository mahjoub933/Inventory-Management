package com.mahjoub.Gestiondestock.services.impl;

import com.mahjoub.Gestiondestock.DAO.Fournisseur;
import com.mahjoub.Gestiondestock.DTO.FournisseurDto;
import com.mahjoub.Gestiondestock.Exceptions.EntityNotFoundException;
import com.mahjoub.Gestiondestock.Exceptions.ErrorCode;
import com.mahjoub.Gestiondestock.Exceptions.InvalidEntityException;
import com.mahjoub.Gestiondestock.Repository.FournisseurRepository;
import com.mahjoub.Gestiondestock.services.FournisseurService;
import com.mahjoub.Gestiondestock.validators.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class FournisseurServieImpl implements FournisseurService {

    private FournisseurRepository fournisseurRepository;
    @Autowired
    public FournisseurServieImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        List<String>erros= FournisseurValidator.validate(fournisseurDto);
        if(!erros.isEmpty()){
            log.error("le fournisseur n'est pas valide",fournisseurDto);
            throw new InvalidEntityException("le fournisseur n'est pas valide",ErrorCode.FOURNISSEUR_NOT_VALID,erros);
        }
        return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEtity(fournisseurDto)));
    }

    @Override
    public FournisseurDto findById(Integer id) {
       if(id==null){
           log.error("l'id fournisseur est nulle");
           return null;
       }
        Optional<Fournisseur> fournisseur= fournisseurRepository.findById(id);
       return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).
               orElseThrow(()->new EntityNotFoundException
                       ("le fournisseur de l'id"+id+"n'a pas trouvé dans la BDD",
                               ErrorCode.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public FournisseurDto findbyCodeFournisseur(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("le code de fournisseur n'est pas valide");
        }
        Optional<Fournisseur>fournisseur=fournisseurRepository.findByCodeFournisseur(code);
        return
                Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(()->new EntityNotFoundException("le fournisseur de code "+code+"n'a pas trouvé dans la BDD",ErrorCode.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream().map(FournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteFournisseur(Integer id) {
      if(id==null){
          log.error("l'id est nulle");
          return;
      }
      fournisseurRepository.deleteById(id);
    }
}
