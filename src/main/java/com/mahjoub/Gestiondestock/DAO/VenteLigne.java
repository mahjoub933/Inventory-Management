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

@Table(name="venteligne")
public class VenteLigne extends AbstractEntity {

    @Column(name="quantite")
    private BigDecimal quantite;
    @Column(name = "prixunitaire")
    private BigDecimal prixunitaire;

    @ManyToOne
    @JoinColumn(name = "vente_id")
    private Vente vente;


    @ManyToOne
    @JoinColumn(name = "articles_id")
    private Article articles;


}
