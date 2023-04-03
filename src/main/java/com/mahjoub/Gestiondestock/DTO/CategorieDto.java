package com.mahjoub.Gestiondestock.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahjoub.Gestiondestock.DAO.Categorie;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CategorieDto {

    private Integer id;

    private String code;

    private String designationc;

    private List<ArticleDto> articles;

    public static CategorieDto fromEntity(Categorie categorie){
        if(categorie==null){
            return null;
        }
        return CategorieDto.builder().id(categorie.getId()).code(categorie.getCode()).
                designationc(categorie.getDesignationc()).build();
    }

    public static Categorie toEntity(CategorieDto categorieDto){
        if(categorieDto==null){
            return null;
        }
        Categorie categorie=new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setCode(categorieDto.getCode());
        categorie.setDesignationc(categorieDto.getDesignationc());
        return categorie;

    }
}
