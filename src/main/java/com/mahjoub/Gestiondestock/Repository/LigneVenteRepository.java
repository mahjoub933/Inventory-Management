package com.mahjoub.Gestiondestock.Repository;

import com.mahjoub.Gestiondestock.DAO.VenteLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneVenteRepository extends JpaRepository<VenteLigne,Integer> {
}
