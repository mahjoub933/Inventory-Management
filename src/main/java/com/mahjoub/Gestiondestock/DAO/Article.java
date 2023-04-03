package com.mahjoub.Gestiondestock.DAO;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="article")
public class Article extends AbstractEntity {
    @Column(name="codesarticle")
    private String codeArticle;
    @Column(name="designation")
    private String designation;
    @Column(name="prixunitaireht")
    private BigDecimal prixUnitaireHT;
    @Column(name="tauxtva")
    private BigDecimal tauxTVA;
    @Column(name="prixunitairettc")
    private BigDecimal prixUnitaireTTC;
    @Column(name="photo")
    private String photo;
    @ManyToOne
    private Categorie category;
    @OneToMany(mappedBy = "articles")
    private List<VenteLigne> venteLignes;
    @Column(name="identreprise")
    private Integer idEntreprise;




}
