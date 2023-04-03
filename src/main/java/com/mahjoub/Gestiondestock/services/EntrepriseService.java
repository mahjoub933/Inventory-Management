package com.mahjoub.Gestiondestock.services;

import com.mahjoub.Gestiondestock.DTO.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDto save(EntrepriseDto entrepriseDto);
    EntrepriseDto findById(Integer id);
    EntrepriseDto findByCodeEntreprise(String code);
    List<EntrepriseDto> findAll();
    void deleteEntreprise(Integer id);

}
