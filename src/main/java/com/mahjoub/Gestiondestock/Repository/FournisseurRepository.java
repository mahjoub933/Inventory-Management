package com.mahjoub.Gestiondestock.Repository;


import com.mahjoub.Gestiondestock.DAO.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FournisseurRepository extends JpaRepository< Fournisseur,Integer> {

    Optional<Fournisseur> findByCodeFournisseur(String code);
}
