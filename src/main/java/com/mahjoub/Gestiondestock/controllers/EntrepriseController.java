package com.mahjoub.Gestiondestock.controllers;

import com.mahjoub.Gestiondestock.DTO.EntrepriseDto;
import com.mahjoub.Gestiondestock.controllers.api.EntrepriseApi;
import com.mahjoub.Gestiondestock.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class EntrepriseController implements EntrepriseApi {

    private EntrepriseService entrepriseService;
@Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        return entrepriseService.save(entrepriseDto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public EntrepriseDto findByCodeEntreprise(String code) {
        return entrepriseService.findByCodeEntreprise(code);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void deleteEntreprise(Integer id) {
       entrepriseService.deleteEntreprise(id);
    }
}
