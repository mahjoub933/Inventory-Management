package com.mahjoub.Gestiondestock.services.impl;

import com.mahjoub.Gestiondestock.DAO.Article;
import com.mahjoub.Gestiondestock.DAO.Vente;
import com.mahjoub.Gestiondestock.DAO.VenteLigne;
import com.mahjoub.Gestiondestock.DTO.VenteDto;
import com.mahjoub.Gestiondestock.DTO.VenteLigneDto;
import com.mahjoub.Gestiondestock.Exceptions.EntityNotFoundException;
import com.mahjoub.Gestiondestock.Exceptions.ErrorCode;
import com.mahjoub.Gestiondestock.Exceptions.InvalidEntityException;
import com.mahjoub.Gestiondestock.Repository.ArticleRepository;
import com.mahjoub.Gestiondestock.Repository.VenteLigneRepository;
import com.mahjoub.Gestiondestock.Repository.VenteRepository;
import com.mahjoub.Gestiondestock.services.VenteService;
import com.mahjoub.Gestiondestock.validators.VenteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class VenteServiceImpl implements VenteService {

    private VenteRepository venteRepository;
    private ArticleRepository articleRepository;
    private VenteLigneRepository venteLigneRepository;
@Autowired
    public VenteServiceImpl(VenteRepository venteRepository, ArticleRepository articleRepository, VenteLigneRepository venteLigneRepository) {
        this.venteRepository = venteRepository;
        this.articleRepository = articleRepository;
        this.venteLigneRepository = venteLigneRepository;
    }

    @Override
    public VenteDto save(VenteDto venteDto) {
        List<String>errors= VenteValidator.validate(venteDto);
        if(!errors.isEmpty()){
            log.error("le vente n'est pas valide",errors);
            throw new InvalidEntityException("le vente n'est pas valide", ErrorCode.VENTE_NOT_VALID,errors);
        }
        List<String> articleErrors= new ArrayList<>();

        venteDto.getVenteLigne().forEach(venteLigneDto ->{
            Optional<Article>article=articleRepository.findById(venteLigneDto.getArticles().getId());
            if(article.isEmpty()){
                articleErrors.add("l'article de l'ID"+venteLigneDto.getArticles().getId()+"n'existe pas dans la BDD");
            }
        });
        if (!articleErrors.isEmpty()) {
            log.warn("un ou plusieurs article n'existe pas ",errors);
            throw new InvalidEntityException("l'article n'est pas existe dans la BDD",
                    ErrorCode.ARTICLE_NOT_VALID, articleErrors);
        }
        Vente saveVente= venteRepository.save(VenteDto.toEntity(venteDto));
        if(venteDto.getVenteLigne()!=null){
            venteDto.getVenteLigne().forEach(venteLig->{
                VenteLigne venteLigne= VenteLigneDto.toEntity(venteLig);
                venteLigne.setVente(saveVente);
                venteLigneRepository.save(venteLigne);
            });
        }

        return VenteDto.fromEntity(saveVente);
    }

    @Override
    public VenteDto findById(Integer id) {
        if(id==null){
            log.error("l'id de vente est vide");
            return venteRepository.findById(id).map(VenteDto::fromEntity).orElseThrow(()
                    ->new EntityNotFoundException("la vente de l'id "+id+"n'est pas existe dans la BDD"
            ,ErrorCode.VENTE_NOT_FOUND));
        }

        return null;
    }

    @Override
    public VenteDto findBycodeVente(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("le code de vente est vide");
        }
        return venteRepository.findByCodevente(code).map(VenteDto::fromEntity).orElseThrow(()->
                new EntityNotFoundException("la vente de l'id "+code+"n'est pas existe dans la BDD"
                        ,ErrorCode.VENTE_NOT_FOUND));
    }

    @Override
    public List<VenteDto> findAll() {
        return venteRepository.findAll().stream().map(VenteDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void DeleteVente(Integer id) {
        venteRepository.deleteById(id);

    }
}
