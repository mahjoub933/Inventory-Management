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
@Table(name="commandefournisseur")
public class CommandeFournisseur extends AbstractEntity {
    @Column(name ="codecommandefournisseur")
    private String codef;
    @Column(name ="datecommandefournisseur")
    private Instant datecommande;
     @ManyToOne
    @JoinColumn(name = "idfournisseur")
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "commandeFournisseur")
    private List<LigneCommandeFournisseur>ligneCommandeFournisseurs;

}
