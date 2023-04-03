package com.mahjoub.Gestiondestock.Repository;


import com.mahjoub.Gestiondestock.DAO.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

    Optional<Utilisateur> findByCodeUser(String code);


    Optional<Utilisateur> findUtilisateurByEmailU(@Param("email") String emailU);
}
