package com.mahjoub.Gestiondestock.DAO;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="mouvstock")
public class MvtStk extends AbstractEntity {

    @Column(name="codemouv")
    private String codemvstock;
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    @Column(name="datemouvstock")
    private Instant datevst;
    @Column(name="quantite")
    private BigDecimal quantite;
    @Column(name="typemvtstock")
    private BigDecimal typemvt;
}
