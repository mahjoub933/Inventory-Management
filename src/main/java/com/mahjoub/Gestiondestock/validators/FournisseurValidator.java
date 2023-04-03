package com.mahjoub.Gestiondestock.validators;


import com.mahjoub.Gestiondestock.DTO.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {
    public static List<String> validate(FournisseurDto fournisseurDto) {
        List<String> errors = new ArrayList<>();

        if(fournisseurDto==null){
            errors.add("veuillez renseigner le nom de fournisseur");
            errors.add("veuillez renseigner le prenom de fournisseur");
            errors.add("veuillez renseigner l'email ");
            errors.add("veuillez renseigner le numero de telephone");
            errors.add("remplir l'adresse de fournisseur");
            return errors;

        }

        if(!StringUtils.hasLength(fournisseurDto.getNom())){
            errors.add("veuillez renseigner le nom de fournisseur");
        }
        if(!StringUtils.hasLength(fournisseurDto.getPrenom())){
            errors.add("veuillez renseigner le prenom de fournisseur");
        }
        if(!StringUtils.hasLength(fournisseurDto.getEmail())){
            errors.add("veuillez renseigner l'email ");
        }
        if(!StringUtils.hasLength(fournisseurDto.getNumtel())){
            errors.add("veuillez renseigner le numero de telephone");
        }
        if(fournisseurDto.getAdresse()==null){
            errors.add("remplir l'adresse de fournisseur");
        }else{
            if(!StringUtils.hasLength(fournisseurDto.getAdresse().getAdresse1())){
                errors.add("le champ 'Adresse1' est obligatoire ");
            }
            if(!StringUtils.hasLength(fournisseurDto.getAdresse().getVille())){
                errors.add("le champ 'Ville' est obligatoire ");
            }
            if(!StringUtils.hasLength(fournisseurDto.getAdresse().getCodepostal())){
                errors.add("le champ 'Code Postale' est obligatoire ");
            }
            if(!StringUtils.hasLength(fournisseurDto.getAdresse().getPays())){
                errors.add("le champ 'Pays' est obligatoire ");
            }}
        return errors;
    }
}
