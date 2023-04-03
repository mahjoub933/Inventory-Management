package com.mahjoub.Gestiondestock.services;

import com.mahjoub.Gestiondestock.DTO.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    FournisseurDto save (FournisseurDto fournisseurDto);
    FournisseurDto findById(Integer id);
    FournisseurDto findbyCodeFournisseur(String code);
    List<FournisseurDto>findAll();
    void deleteFournisseur(Integer id);
}
