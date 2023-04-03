package com.mahjoub.Gestiondestock.controllers;

import com.mahjoub.Gestiondestock.DTO.CategorieDto;
import com.mahjoub.Gestiondestock.controllers.api.CategorieApi;
import com.mahjoub.Gestiondestock.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CategorieController implements CategorieApi {

    private CategorieService categorieService;

@Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @Override
    public CategorieDto saveCa(CategorieDto categorieDto) {
        return categorieService.save(categorieDto);
    }

    @Override
    public CategorieDto findById(Integer id) {
        return categorieService.findById(id);
    }

    @Override
    public CategorieDto findByCodeCategorie(String code) {
        return categorieService.findByCode(code);
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieService.findAll();
    }

    @Override
    public void deleteCategorie(Integer id) {
      categorieService.deleteCategory(id);
    }
}
