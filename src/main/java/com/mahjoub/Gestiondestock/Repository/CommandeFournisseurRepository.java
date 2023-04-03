package com.mahjoub.Gestiondestock.Repository;

import com.mahjoub.Gestiondestock.DAO.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository< CommandeFournisseur,Integer> {

    Optional<CommandeFournisseur> findByCodef(String code);
}
