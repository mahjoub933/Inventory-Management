package com.mahjoub.Gestiondestock.DAO;

import lombok.*;

import javax.persistence.*;

import java.util.List;


@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="utilisateur")
public class Utilisateur extends AbstractEntity {
    @Column(name="codeutilisateur")
    private String codeUser;
    @Column(name="nomutilisateur")
    private String nomU;
    @Column(name="prenomutilisateur")
    private String prenomU;
    @Column(name="photo")
    private String photoU;
    @Column(name="email")
    private String emailU;
    @Column(name="motdepasse")
    private String motdepasse;

    @Embedded
    private Adresse adresse;
    @ManyToOne
    @JoinColumn (name="identreprise")
    private Entreprise entreprise;
    @OneToMany(mappedBy = "utilisateur")
    private List<Role>roles;
}
