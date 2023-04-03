package com.mahjoub.Gestiondestock.services;

import com.mahjoub.Gestiondestock.DAO.Categorie;
import com.mahjoub.Gestiondestock.DTO.CategorieDto;

import java.util.List;

public interface CategorieService {
    CategorieDto save(CategorieDto categorieDto);
    CategorieDto findById(Integer id);
    CategorieDto findByCode(String code);
    List<CategorieDto>findAll();
    void deleteCategory(Integer id);

}
