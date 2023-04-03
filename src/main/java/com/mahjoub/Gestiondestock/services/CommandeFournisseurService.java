package com.mahjoub.Gestiondestock.services;

import com.mahjoub.Gestiondestock.DAO.CommandeFournisseur;
import com.mahjoub.Gestiondestock.DTO.CommandeFournisseurDto;


import java.util.List;

public interface CommandeFournisseurService {
    CommandeFournisseurDto save(CommandeFournisseurDto dto);
    CommandeFournisseurDto findById(Integer id);
    CommandeFournisseurDto findByCodeComFournisseur(String code);
    List<CommandeFournisseurDto> findAll();
    void deleteComFournisseur(Integer id);
}
