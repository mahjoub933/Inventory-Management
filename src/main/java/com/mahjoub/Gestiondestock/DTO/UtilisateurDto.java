package com.mahjoub.Gestiondestock.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahjoub.Gestiondestock.DAO.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder

public class UtilisateurDto {

    private Integer id;

    private String codeUser;

    private String nomU;

    private String prenomU;

    private String photoU;

    private String emailU;

    private String motdepasse;

    private AdresseDto adresse;

    private EntrepriseDto entreprise;

    private List<RoleDto> roles;

    public static  UtilisateurDto fromEntity(Utilisateur utilisateur){
        if(utilisateur==null){
            return null;
        }
        return UtilisateurDto.builder().id(utilisateur.getId()).nomU(utilisateur.getNomU()).prenomU(utilisateur.getPrenomU())
                .photoU(utilisateur.getPhotoU()).emailU(utilisateur.getEmailU()).motdepasse(utilisateur.getMotdepasse())
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise())).roles(utilisateur.getRoles()!=null ?
                        utilisateur.getRoles().stream()
                                .map(RoleDto::fromEntity)
                                .collect(Collectors.toList()) : null).
                        adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .build();
    }
    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if(utilisateurDto==null){
            return null;
        }
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNomU(utilisateurDto.getNomU());
        utilisateur.setPrenomU(utilisateurDto.getPrenomU());
        utilisateur.setPhotoU(utilisateurDto.getPhotoU());
        utilisateur.setEmailU(utilisateurDto.getEmailU());
        utilisateur.setMotdepasse(utilisateurDto.getMotdepasse());


        return utilisateur;

    }
}
