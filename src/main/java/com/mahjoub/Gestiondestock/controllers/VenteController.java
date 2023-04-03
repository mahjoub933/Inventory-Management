package com.mahjoub.Gestiondestock.controllers;

import com.mahjoub.Gestiondestock.DTO.VenteDto;
import com.mahjoub.Gestiondestock.controllers.api.VenteApi;
import com.mahjoub.Gestiondestock.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenteController implements VenteApi {

    private VenteService venteService;
   @Autowired
    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @Override
    public VenteDto save(VenteDto venteDto) {
        return venteService.save(venteDto);
    }

    @Override
    public VenteDto findById(Integer id) {
        return venteService.findById(id);
    }

    @Override
    public VenteDto findBycodeVente(String code) {
        return venteService.findBycodeVente(code);
    }

    @Override
    public List<VenteDto> findAll() {
        return venteService.findAll();
    }

    @Override
    public void DeleteVente(Integer id) {
      venteService.DeleteVente(id);
    }
}
