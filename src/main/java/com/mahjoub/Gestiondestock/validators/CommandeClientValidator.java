package com.mahjoub.Gestiondestock.validators;

import com.mahjoub.Gestiondestock.DTO.CategorieDto;
import com.mahjoub.Gestiondestock.DTO.ClientDto;
import com.mahjoub.Gestiondestock.DTO.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
    public static List<String> validate(CommandeClientDto commandeClientDto){
        List<String>errors=new ArrayList<>();
        if(commandeClientDto==null){
            errors.add("veuillez renseigner le code de la commande client");
            errors.add("la date de commande client est null");
            errors.add("veuillez renseigner le client");

        }
      if(!StringUtils.hasLength(commandeClientDto.getCodecom())){
          errors.add("errors.add(\"veuillez renseigner le code de la commande client\");");
      }
      if(commandeClientDto.getDatecom()==null){
          errors.add("la date de commande client est null");
      }
      if(commandeClientDto.getClients()==null){
          errors.add("veuillez renseigner le client");
      }
      return errors;
}}
