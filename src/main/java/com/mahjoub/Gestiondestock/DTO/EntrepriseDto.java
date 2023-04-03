package com.mahjoub.Gestiondestock.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahjoub.Gestiondestock.DAO.Adresse;
import com.mahjoub.Gestiondestock.DAO.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder

public class EntrepriseDto {

    private Integer id;

    private String codeEntreprise;

    private String nomE;

    private String description;

    private String codefiscal;

    private String photoE;

    private String emailE;

    private String numtelE;


    private AdresseDto adresse;

    private List<UtilisateurDto> utilisateur;

    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if(entreprise==null){
            return null;
        }
        return EntrepriseDto.builder().id(entreprise.getId()).nomE(entreprise.getNomE())
                .description(entreprise.getDescription()).codefiscal(entreprise.getCodefiscal())
                .photoE(entreprise.getPhotoE()).emailE(entreprise.getEmailE()).numtelE(entreprise.getNumtelE())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse())).utilisateur(entreprise.getUtilisateur()!=null?
                        entreprise.getUtilisateur().stream().map(UtilisateurDto::fromEntity).
                                collect(Collectors.toList()):null)
                .build();
    }
    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if(entrepriseDto==null){
            return null;
        }
        Entreprise entreprise=new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNomE(entrepriseDto.getNomE());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setCodefiscal(entrepriseDto.getCodefiscal());
        entreprise.setEmailE(entrepriseDto.getEmailE());
        entreprise.setPhotoE(entrepriseDto.getPhotoE());
        entreprise.setNumtelE(entrepriseDto.getNumtelE());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
        return entreprise;
    }
}

