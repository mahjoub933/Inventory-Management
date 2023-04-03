package com.mahjoub.Gestiondestock.DAO;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="entreprise")
public class Entreprise extends AbstractEntity {
    @Column(name="codeentreprise")
    private String codeEntreprise;

    @Column(name="nomentreprise")
    private String nomE;

    @Column(name="description")
    private String description;

    @Column(name="codefiscal")
    private String codefiscal;

    @Column(name="photoentreprise")
    private String photoE;

    @Column(name="emailentreprise")
    private String emailE;

    @Column(name="numerotelentreprise")
    private String numtelE;

    @Embedded
    private Adresse adresse;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateur;

}

