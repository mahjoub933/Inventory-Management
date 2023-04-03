package com.mahjoub.Gestiondestock.Repository;

import com.mahjoub.Gestiondestock.DAO.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ArticleRepository extends JpaRepository< Article,Integer> {


    Optional<Article> findArticleByCodeArticle(String code);
}
