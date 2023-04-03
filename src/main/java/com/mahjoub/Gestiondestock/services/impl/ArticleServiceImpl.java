package com.mahjoub.Gestiondestock.services.impl;

import com.mahjoub.Gestiondestock.DAO.Article;
import com.mahjoub.Gestiondestock.DTO.ArticleDto;
import com.mahjoub.Gestiondestock.Exceptions.EntityNotFoundException;
import com.mahjoub.Gestiondestock.Exceptions.ErrorCode;
import com.mahjoub.Gestiondestock.Exceptions.InvalidEntityException;
import com.mahjoub.Gestiondestock.Repository.ArticleRepository;
import com.mahjoub.Gestiondestock.services.ArticleService;
import com.mahjoub.Gestiondestock.validators.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {


    private ArticleRepository articleRepository;
@Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String>errors= ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()){
            log.error("l'article n'est pas valide",articleDto);
            throw new InvalidEntityException("l'article n'est pas valide", ErrorCode.ARTICLE_NOT_VALID,errors);
        }
        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id==null){
            log.error("article id est nulle");
            return  null;
        }
        Optional<Article> article= articleRepository.findById(id);
       /* ArticleDto dto= ArticleDto.fromEntity(article.get());
        return Optional.of(dto).orElseThrow(()-> new EntityNotFoundException(
                "Aucun article avec l'ID ="+id+"n'a eté  trouver dans la BDD",ErrorCode.ARTICLE_NOT_FOUND
        ));*/

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()-> new EntityNotFoundException(
                "Aucun article avec l'ID ="+id+"n'a eté  trouver dans la BDD",ErrorCode.ARTICLE_NOT_FOUND
        ));
    }

    @Override
    public ArticleDto findByCodeArticle(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("l'article eest nulle");
            return null;
        }
        Optional<Article> article= articleRepository.findArticleByCodeArticle(code);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()-> new EntityNotFoundException(
                "Aucun article avec le code article  ="+code+"n'a eté  trouver dans la BDD",ErrorCode.ARTICLE_NOT_FOUND
        ));
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("article id est nulle");
            return ;
        }
        articleRepository.deleteById(id);

    }
}
