package com.mahjoub.Gestiondestock.Repository;


import com.mahjoub.Gestiondestock.DAO.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Integer> {

    Optional<Vente> findByCodevente(String code);
}
