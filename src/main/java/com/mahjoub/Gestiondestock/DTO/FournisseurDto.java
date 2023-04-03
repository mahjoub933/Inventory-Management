package com.mahjoub.Gestiondestock.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahjoub.Gestiondestock.DAO.Fournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class FournisseurDto {

    private Integer id;

    private String codeFournisseur;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photoc;

    private String email;

    private String numtel;


    private List<CommandeFournisseurDto> commandeFournisseur;

    public static FournisseurDto fromEntity(Fournisseur fournisseur){
        if(fournisseur==null){
            return null;
        }
        return FournisseurDto.builder().id(fournisseur.getId()).nom(fournisseur.getNom()).prenom(fournisseur.getPrenom())
                .photoc(fournisseur.getPhotoc()).email(fournisseur.getEmail()).numtel(fournisseur.getNumtel()).build();
    }
    public static Fournisseur toEtity(FournisseurDto fournisseurDto){
        if(fournisseurDto==null){
            return null;
        }
        Fournisseur fournisseur=new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setEmail(fournisseurDto.getEmail());
        fournisseur.setPhotoc(fournisseurDto.getPhotoc());
        fournisseur.setNumtel(fournisseurDto.getNumtel());
        return fournisseur;
    }
}
