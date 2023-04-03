package com.mahjoub.Gestiondestock.DTO;


import com.mahjoub.Gestiondestock.DAO.LigneCommandeClient;
import com.mahjoub.Gestiondestock.DAO.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {

    private Integer id;

    private ArticleDto article;


    private CommandeFournisseurDto commandeFournisseur;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
        if(ligneCommandeFournisseur==null){
            return null;
        }
        return LigneCommandeFournisseurDto.builder().id(ligneCommandeFournisseur.getId()).build();
    }
    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        if(ligneCommandeFournisseurDto==null){
            return null;

        }
        LigneCommandeFournisseur ligneCommandeFournisseur=new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseur.getId());
        return ligneCommandeFournisseur;
    }
}
