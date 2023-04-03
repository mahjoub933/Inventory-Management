package com.mahjoub.Gestiondestock.Repository;

import com.mahjoub.Gestiondestock.DAO.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Integer> {
}
