package com.mahjoub.Gestiondestock.services;

import com.mahjoub.Gestiondestock.DTO.ArticleDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ArticleService {
    ArticleDto save(ArticleDto articleDto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String code);

    List<ArticleDto> findAll();

    void delete(Integer id);
}
