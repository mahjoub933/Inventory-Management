package com.mahjoub.Gestiondestock.validators;

import com.mahjoub.Gestiondestock.DTO.EntrepriseDto;
import com.mahjoub.Gestiondestock.DTO.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto entrepriseDto) {
        List<String> errors = new ArrayList<>();

        if(entrepriseDto==null){
            errors.add("veuillez saisir le nom d'entreprise");
            errors.add("veuillez saisir l'email d'entreprise");
            errors.add("veuillez saisir le numero de telephone  d'entreprise");
            errors.add("veuillez saisir le code Fiscal d'entreprise");
            errors.add("veuillez saisir le description  d'entreprise");
            errors.add("saisir l'adresse d'entreprise");
            return errors;
        }

     if(!StringUtils.hasLength(entrepriseDto.getNomE())){
         errors.add("veuillez saisir le nom d'entreprise");
     }
        if(!StringUtils.hasLength(entrepriseDto.getEmailE())){
            errors.add("veuillez saisir l'email d'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getNumtelE())){
            errors.add("veuillez saisir le numero de telephone  d'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getCodefiscal())){
            errors.add("veuillez saisir le code Fiscal d'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getDescription())){
            errors.add("veuillez saisir le description  d'entreprise");
        }
        if(entrepriseDto.getAdresse()==null){
            errors.add("saisir l'adresse d'entreprise");
        }


        return errors;
    }
}
