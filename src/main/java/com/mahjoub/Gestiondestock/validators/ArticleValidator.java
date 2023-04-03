package com.mahjoub.Gestiondestock.validators;

import com.mahjoub.Gestiondestock.DTO.ArticleDto;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto articleDto) {
        List<String> errors = new ArrayList<>();

        if(articleDto==null){
            errors.add("veuillez renseigner le code d'article");
            errors.add("veuillez renseigner le designation");
            errors.add("veuillez renseigner le prix unitaire");
            errors.add("veuillez renseigner le prix TTC");
            errors.add("veuillez renseigner le taux TVA");
            errors.add("veuillez selectionner categorie");
            return errors;

        }

     if(!StringUtils.hasLength(articleDto.getCodeArticle())){
         errors.add("veuillez renseigner le code d'article");
     }
        if(!StringUtils.hasLength(articleDto.getDesignation())) {
            errors.add("veuillez renseigner le designation");
        }
        if(articleDto.getPrixUnitaireHT()==null){
            errors.add("veuillez renseigner le prix unitaire");
        }
        if(articleDto.getPrixUnitaireTTC()==null){
            errors.add("veuillez renseigner le prix TTC");
        }
        if(articleDto.getTauxTVA()==null){
            errors.add("veuillez renseigner le taux TVA");
        }
        if(articleDto.getCategory()==null){
            errors.add("veuillez selectionner categorie");
        }
        return errors;
    }
    }
