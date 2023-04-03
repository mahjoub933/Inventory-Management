package com.mahjoub.Gestiondestock.DAO;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name="lignecommandefournisseur")
public class LigneCommandeFournisseur extends AbstractEntity {


    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idcommandefournisser")
    private CommandeFournisseur commandeFournisseur;
}
