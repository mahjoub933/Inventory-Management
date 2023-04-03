package com.mahjoub.Gestiondestock.DTO;


import com.mahjoub.Gestiondestock.DAO.Article;
import com.mahjoub.Gestiondestock.DAO.VenteLigne;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHT;

    private BigDecimal tauxTVA;

    private BigDecimal prixUnitaireTTC;

    private String photo;

    private CategorieDto category;

    private VenteLigneDto venteligne;

    private Integer idEntreprise;

   public static ArticleDto fromEntity(Article ar){
       if(ar==null){
           return null;
       }
       return ArticleDto.builder().id(ar.getId()).codeArticle(ar.getCodeArticle()).designation(ar.getDesignation())
               .photo(ar.getPhoto()).prixUnitaireHT(ar.getPrixUnitaireHT()).prixUnitaireTTC(ar.getPrixUnitaireTTC())
               .tauxTVA(ar.getTauxTVA()).category(CategorieDto.fromEntity(ar.getCategory())).idEntreprise(ar.getIdEntreprise()).build();   }

    public static Article toEntity(ArticleDto arDto){
       if(arDto==null){
           return null;
       }
        Article ar=  new Article();
       ar.setId(arDto.getId());
       ar.setCodeArticle(arDto.getCodeArticle());
       ar.setDesignation(arDto.getDesignation());
       ar.setPhoto(arDto.getPhoto());
       ar.setPrixUnitaireHT(arDto.getPrixUnitaireHT());
       ar.setPrixUnitaireTTC(arDto.getPrixUnitaireTTC());
       ar.setTauxTVA(arDto.getTauxTVA());
       ar.setIdEntreprise(arDto.getIdEntreprise());
       return ar;

    }
}
