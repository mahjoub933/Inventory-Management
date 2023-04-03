package com.mahjoub.Gestiondestock.Repository;

import com.mahjoub.Gestiondestock.DAO.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CommandeClientRepository extends JpaRepository< CommandeClient,Integer> {

    Optional<CommandeClient> findByCodecom(String codecom);
}
