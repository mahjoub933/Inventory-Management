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
@Table(name="commandeclient")
public class CommandeClient extends AbstractEntity {
    @Column(name="codecommande")
    private String codecom;
    @Column(name="datecommande")
    private Instant datecom;
    @ManyToOne
    @JoinColumn(name="idclient")
    private Client clients;
    @OneToMany(mappedBy = "commandeclients")
    private List<LigneCommandeClient>lignecommandeclient;


}
