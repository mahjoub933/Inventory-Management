package com.mahjoub.Gestiondestock.DAO;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name= "categorie")
public class Categorie extends AbstractEntity {
    @Column(name= "codecategorie")
    private String code;
    @Column(name= "designationcategorie")
    private String designationc;
    @OneToMany(mappedBy = "category")
    private List <Article>articles;
}