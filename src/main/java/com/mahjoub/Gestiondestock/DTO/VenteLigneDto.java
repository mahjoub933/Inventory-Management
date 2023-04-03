package com.mahjoub.Gestiondestock.DTO;

import com.mahjoub.Gestiondestock.DAO.Article;
import com.mahjoub.Gestiondestock.DAO.Vente;
import com.mahjoub.Gestiondestock.DAO.VenteLigne;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class VenteLigneDto {

    private Integer id;

    private VenteDto vente;

    private BigDecimal quantite;

    private BigDecimal prixunitaire;

    private Article articles;




    public static VenteLigneDto fromEntity(VenteLigne venteLigne){
        if(venteLigne==null){
            return null;
        }
        return VenteLigneDto.builder().id(venteLigne.getId()).quantite(venteLigne.getQuantite())
                .prixunitaire(venteLigne.getPrixunitaire()).build();
    }
    public static VenteLigne toEntity(VenteLigneDto venteLigneDto){
        if(venteLigneDto==null){
            return null;
        }
        VenteLigne venteLigne=new VenteLigne();
        venteLigne.setId(venteLigneDto.getId());
        venteLigne.setQuantite(venteLigneDto.getQuantite());
        venteLigne.setPrixunitaire(venteLigneDto.getPrixunitaire());
        return venteLigne;
    }
}
