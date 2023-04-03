package com.mahjoub.Gestiondestock.DTO;


import com.mahjoub.Gestiondestock.DAO.CommandeFournisseur;
import com.mahjoub.Gestiondestock.DAO.Fournisseur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder

public class CommandeFournisseurDto {

    private Integer id;

    private String codef;

    private Instant datecommande;

    private Fournisseur fournisseur;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        if(commandeFournisseur==null){
            return null;
        }
        return CommandeFournisseurDto.builder().id(commandeFournisseur.getId()).codef(commandeFournisseur.getCodef())
                .datecommande(commandeFournisseur.getDatecommande()).build();
    }
public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if(commandeFournisseurDto==null){
            return null;
        }
        CommandeFournisseur commandeFournisseur=new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCodef(commandeFournisseurDto.getCodef());
        commandeFournisseur.setDatecommande(commandeFournisseurDto.getDatecommande());
        return commandeFournisseur;
    }
}
