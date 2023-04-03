package com.mahjoub.Gestiondestock.Repository;


import com.mahjoub.Gestiondestock.DAO.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MvtStkRepository extends JpaRepository< MvtStk,Integer> {


    Optional<MvtStk> findByCodemvstock(String code);
}
