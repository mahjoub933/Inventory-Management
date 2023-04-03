package com.mahjoub.Gestiondestock.services;

import com.mahjoub.Gestiondestock.DTO.ClientDto;
import com.mahjoub.Gestiondestock.DTO.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto dto);
    UtilisateurDto findById(Integer id);
    UtilisateurDto findByCodeClient(String code);
    List<UtilisateurDto> findAll();
    void deleteUser(Integer id);
     UtilisateurDto findByEmailU(String email);
}
