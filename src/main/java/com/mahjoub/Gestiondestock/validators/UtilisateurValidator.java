package com.mahjoub.Gestiondestock.validators;

import com.mahjoub.Gestiondestock.DTO.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String>errors=new ArrayList<>();


        if(utilisateurDto==null){
            errors.add("veuillez remplir le nom d'utilisateur ");
            errors.add("veuillez remplir le prenom d'utilisateur ");
            errors.add("veuillez remplir l'email  d'utilisateur ");
            errors.add("veuillez remplir le mot de passe  d'utilisateur ");
            errors.add("veuillez saisir l'adresse  d'utilisateur ");
            return errors;

        }

        if(!StringUtils.hasLength(utilisateurDto.getNomU())){
            errors.add("veuillez remplir le nom d'utilisateur ");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPrenomU())){
            errors.add("veuillez remplir le prenom d'utilisateur ");
        }

        if(!StringUtils.hasLength(utilisateurDto.getEmailU())) {
            errors.add("veuillez remplir l'email  d'utilisateur ");
        }
            if(!StringUtils.hasLength(utilisateurDto.getMotdepasse())){
                errors.add("veuillez remplir le mot de passe  d'utilisateur ");
            }
            if(utilisateurDto.getAdresse()==null){
                errors.add("veuillez inserer l'adresse  d'utilisateur ");
            }else{
                if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
                    errors.add("le champ 'Adresse1' est obligatoire ");
                }
                if(!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                    errors.add("le champ 'Ville' est obligatoire ");
                }
                if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodepostal())){
                    errors.add("le champ 'Code Postale' est obligatoire ");
                }
                if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                    errors.add("le champ 'Pays' est obligatoire ");
                }

            }




        return errors;

    }
}
