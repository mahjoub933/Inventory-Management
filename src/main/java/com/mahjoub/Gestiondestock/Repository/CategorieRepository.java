package com.mahjoub.Gestiondestock.Repository;



import com.mahjoub.Gestiondestock.DAO.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {

    Optional<Categorie> findByCode(String code);
}
