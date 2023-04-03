package com.mahjoub.Gestiondestock.services.impl;

import com.mahjoub.Gestiondestock.DAO.Categorie;
import com.mahjoub.Gestiondestock.DTO.CategorieDto;
import com.mahjoub.Gestiondestock.Exceptions.EntityNotFoundException;
import com.mahjoub.Gestiondestock.Exceptions.ErrorCode;
import com.mahjoub.Gestiondestock.Exceptions.InvalidEntityException;
import com.mahjoub.Gestiondestock.Repository.CategorieRepository;
import com.mahjoub.Gestiondestock.services.CategorieService;
import com.mahjoub.Gestiondestock.validators.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategorieServiceImpl implements CategorieService {
    private CategorieRepository categorieRepository;
    @Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public CategorieDto save(CategorieDto categorieDto) {
        List<String>errors= CategorieValidator.validate(categorieDto);
        if(!errors.isEmpty()){
            log.error("categorie n'est pas valide",categorieDto);
            throw new InvalidEntityException("categorie n'est pas valide", ErrorCode.ARTICLE_NOT_VALID,errors);

        }
        return CategorieDto.fromEntity(categorieRepository.save(CategorieDto.toEntity(categorieDto)));
    }

    @Override
    public CategorieDto findById(Integer id) {
        if(id==null){
            log.error("categorie id est nulle");
        }
        Optional<Categorie> category=categorieRepository.findById(id);
        return Optional.of(CategorieDto.fromEntity(category.get()))
                .orElseThrow(()->new EntityNotFoundException("Aucun categorie avec ID " +
                        ""+id+" trouvé dans la BDD",ErrorCode.CATEGORIE_NOT_FOUND));
    }

    @Override
    public CategorieDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("code de la categorie est nulle");
        }
        /*Optional<Categorie> category=categorieRepository.findByCodeCategory(code);
        return Optional.of(CategorieDto.fromEntity(category.get()))
                .orElseThrow(()-> new EntityNotFoundException
                        (" la categorie avec le codd"+code+"n'a pas trouvédans la BDD",ErrorCode.CATEGORIE_NOT_FOUND));
                      */
        return categorieRepository.findByCode(code).map(CategorieDto::fromEntity).orElseThrow(()-> new EntityNotFoundException
                (" la categorie avec le codd"+code+"n'a pas trouvédans la BDD",ErrorCode.CATEGORIE_NOT_FOUND));
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieRepository.findAll().stream().map(CategorieDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Integer id) {
        if(id==null){
            log.error("la categorie est nulle");
            return;
        }
        categorieRepository.deleteById(id);

    }
}
