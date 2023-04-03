package com.mahjoub.Gestiondestock.DTO;


import com.mahjoub.Gestiondestock.DAO.Vente;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder

public class VenteDto {

    private Integer id;

    private String codevente;


    private Instant datevente;


    private String commentaire;

    private List<VenteLigneDto> venteLigne;

    public static VenteDto fromEntity(Vente vente){
        if(vente==null){
            return null;
        }
        return VenteDto.builder().id(vente.getId()).codevente(vente.getCodevente()).datevente(vente.getDatevente())
                .commentaire(vente.getCommentaire()).build();
    }
    public static Vente toEntity(VenteDto venteDto){
        if (venteDto==null){
            return null;
        }
        Vente vente=new Vente();
        vente.setId(venteDto.getId());
        vente.setCodevente(venteDto.getCodevente());
        vente.setDatevente(venteDto.getDatevente());
        vente.setCommentaire(venteDto.getCommentaire());
        return vente;

    }
}
