package com.mahjoub.Gestiondestock.DTO;

import com.mahjoub.Gestiondestock.DAO.Article;
import com.mahjoub.Gestiondestock.DAO.MvtStk;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.time.Instant;
@Data
@Builder
public class MvtStkDto {

    private Integer id;

    private String codemvstock;

    private ArticleDto article;

    private Instant datevst;

    private BigDecimal quantite;

    private BigDecimal typemvt;

    public static MvtStkDto fromEntity(MvtStk mvtStk){
        if(mvtStk==null){
            return null;
        }
        return MvtStkDto.builder().id(mvtStk.getId()).codemvstock(mvtStk.getCodemvstock()).datevst(mvtStk.getDatevst()).quantite(mvtStk.getQuantite())
                .typemvt(mvtStk.getTypemvt()).build();
    }
    public static MvtStk toEntity(MvtStkDto mvtStkDto){
        if(mvtStkDto==null){
            return null;
        }
        MvtStk mvtStk=new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setCodemvstock(mvtStkDto.getCodemvstock());
        mvtStk.setDatevst(mvtStkDto.getDatevst());
        mvtStk.setQuantite(mvtStkDto.getQuantite());
        mvtStk.setTypemvt(mvtStkDto.getTypemvt());
        return mvtStk;    }
}
