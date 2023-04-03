package com.mahjoub.Gestiondestock.validators;

import com.mahjoub.Gestiondestock.DTO.CommandeClientDto;
import com.mahjoub.Gestiondestock.DTO.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {
    public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto){
    List<String> errors=new ArrayList<>();
        if(commandeFournisseurDto==null){
        errors.add("veuillez renseigner le code de la commande fournisseur");
        errors.add("la date de commande fournisseur est null");
        errors.add("veuillez renseigner le fournisseur");

    }
      if(!StringUtils.hasLength(commandeFournisseurDto.getCodef())){
        errors.add("errors.add(\"veuillez renseigner le code de la commande fournisseur\");");
    }
      if(commandeFournisseurDto.getDatecommande()==null){
        errors.add("la date de commande fournisseur est null");
    }
      if(commandeFournisseurDto.getFournisseur()==null){
        errors.add("veuillez renseigner le fournisseur");
    }
      return errors;
}
}
