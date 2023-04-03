package com.mahjoub.Gestiondestock.DAO;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="fournisseur")
public class Fournisseur extends AbstractEntity {
    @Column(name="codefournisseur")
    private String codeFournisseur;
    @Column(name="nomfournisseur")
    private String nom;
    @Column(name="prenomfournisseur")
    private String prenom;
    @Embedded
    private Adresse adresse;
    @Column(name="photofournisseur")
    private String photoc;
    @Column(name="emailfournisseur")
    private String email;
    @Column(name="numtelfournisseur")
    private String numtel;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur>commandeFournisseur;
}
