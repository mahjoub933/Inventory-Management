package com.mahjoub.Gestiondestock.controllers;

import com.mahjoub.Gestiondestock.DTO.EntrepriseDto;
import com.mahjoub.Gestiondestock.DTO.FournisseurDto;
import com.mahjoub.Gestiondestock.controllers.api.FournisseurApi;
import com.mahjoub.Gestiondestock.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;
@Autowired
    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        return fournisseurService.save(fournisseurDto);
    }

    @Override
    public FournisseurDto findByIdF(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public FournisseurDto findByCodeFournisseur(String code) {
        return fournisseurService.findbyCodeFournisseur(code);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void deleteFournisseur(Integer id) {
    fournisseurService.deleteFournisseur(id);
    }
}
