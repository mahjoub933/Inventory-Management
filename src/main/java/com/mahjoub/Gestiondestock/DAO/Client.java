package com.mahjoub.Gestiondestock.DAO;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="client")
public class Client extends AbstractEntity {
    @Column(name="codeclient")
    private String codeClient;
    @Column(name="nomclient")
    private String nom;
    @Column(name="prenomclient")
    private String prenom;
    @Embedded
    private Adresse adresse;
    @Column(name="photoclient")
    private String photoc;
    @Column(name="emailclient")
    private String email;
    @Column(name="numtelclient")
    private String numtel;
    @OneToMany(mappedBy = "clients")
    private List<CommandeClient>commandeclient;
}
