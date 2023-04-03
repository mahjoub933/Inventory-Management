package com.mahjoub.Gestiondestock.services;

import com.mahjoub.Gestiondestock.DTO.VenteDto;

import java.util.List;

public interface VenteService {
    VenteDto save(VenteDto venteDto);
    VenteDto findById(Integer id);
    VenteDto findBycodeVente(String code);
    List<VenteDto>findAll();
    void DeleteVente(Integer id);
}
