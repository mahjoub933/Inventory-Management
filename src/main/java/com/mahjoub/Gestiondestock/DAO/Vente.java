package com.mahjoub.Gestiondestock.DAO;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="vente")
public class Vente extends AbstractEntity {


    @JoinColumn(name = "codevente")
    private String codevente;

    @JoinColumn(name = "datevente")
    private Instant datevente;

    @JoinColumn(name = "commentaire")
    private String commentaire;

    @OneToMany(mappedBy = "vente")
    private List<VenteLigne> venteLignes;
}
