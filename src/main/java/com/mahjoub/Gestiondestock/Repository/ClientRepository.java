package com.mahjoub.Gestiondestock.Repository;

import com.mahjoub.Gestiondestock.DAO.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository< Client,Integer> {
    Optional<Client> findByCodeClient(String code);
}
