package com.mahjoub.Gestiondestock.validators;

import com.mahjoub.Gestiondestock.DTO.ArticleDto;
import com.mahjoub.Gestiondestock.DTO.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDto clientDto) {
        List<String> errors = new ArrayList<>();

        if(clientDto==null){
            errors.add("veillez saisir votre nom de client");
            errors.add("veillez saisir votre prenom de client");
            errors.add("veillez saisir votre email de client");
            errors.add("veillez saisir votre numero de telephone  de client");
            errors.add("veillez renseigner votre adresse");

            return errors;
        }
        if(!StringUtils.hasLength(clientDto.getNom())){
            errors.add("veillez saisir le nom de client");
        }
        if(!StringUtils.hasLength(clientDto.getPrenom())) {
            errors.add("veillez saisir le prenom de client");
        }
        if(!StringUtils.hasLength(clientDto.getEmail())) {
            errors.add("veillez saisir l'email de client");
        }
        if(!StringUtils.hasLength(clientDto.getNumtel())) {
            errors.add("veillez saisir le numero de telephone  de client");
        }
        if(clientDto.getAdresse()==null){
            errors.add("veillez renseigner l'adresse");
        }


        return  errors;
    }

}
