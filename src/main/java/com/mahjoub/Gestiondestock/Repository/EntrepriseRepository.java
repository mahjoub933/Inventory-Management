package com.mahjoub.Gestiondestock.Repository;

import com.mahjoub.Gestiondestock.DAO.Entreprise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {
    Optional<Entreprise> findByCodeEntreprise(String code);
}
