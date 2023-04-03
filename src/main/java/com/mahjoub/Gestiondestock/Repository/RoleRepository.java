package com.mahjoub.Gestiondestock.Repository;


import com.mahjoub.Gestiondestock.DAO.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
