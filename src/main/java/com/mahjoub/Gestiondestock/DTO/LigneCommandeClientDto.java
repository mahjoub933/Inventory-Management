package com.mahjoub.Gestiondestock.DTO;

import com.mahjoub.Gestiondestock.DAO.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class LigneCommandeClientDto {

    private Integer id;

    private ArticleDto article;

    private CommandeClientDto commandeclients;

    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient){
        if(ligneCommandeClient==null){
            return null;
        }
        return LigneCommandeClientDto.builder().id(ligneCommandeClient.getId()).build();
    }
    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if(ligneCommandeClientDto==null){
            return null;

        }
        LigneCommandeClient ligneCommandeClient=new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        return ligneCommandeClient;
    }
}
