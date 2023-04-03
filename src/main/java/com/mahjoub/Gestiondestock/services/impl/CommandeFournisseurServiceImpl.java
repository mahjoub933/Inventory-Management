package com.mahjoub.Gestiondestock.services.impl;

import com.mahjoub.Gestiondestock.DAO.Article;
import com.mahjoub.Gestiondestock.DAO.CommandeFournisseur;
import com.mahjoub.Gestiondestock.DAO.Fournisseur;
import com.mahjoub.Gestiondestock.DAO.LigneCommandeFournisseur;
import com.mahjoub.Gestiondestock.DTO.CommandeFournisseurDto;
import com.mahjoub.Gestiondestock.DTO.LigneCommandeFournisseurDto;
import com.mahjoub.Gestiondestock.Exceptions.EntityNotFoundException;
import com.mahjoub.Gestiondestock.Exceptions.ErrorCode;
import com.mahjoub.Gestiondestock.Exceptions.InvalidEntityException;
import com.mahjoub.Gestiondestock.Repository.ArticleRepository;
import com.mahjoub.Gestiondestock.Repository.CommandeFournisseurRepository;
import com.mahjoub.Gestiondestock.Repository.FournisseurRepository;
import com.mahjoub.Gestiondestock.Repository.LigneCommandeFournisseurRepository;
import com.mahjoub.Gestiondestock.services.CommandeFournisseurService;
import com.mahjoub.Gestiondestock.services.FournisseurService;
import com.mahjoub.Gestiondestock.validators.CommandeFournisseurValidator;
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
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    private ArticleRepository articleRepository;
@Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository,
                                          FournisseurRepository fournisseurRepository,
                                          LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,
                                          ArticleRepository articleRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("la commande fournisseur n'est pas valide", errors);
            throw new InvalidEntityException("la commande fournisseur n'est pas valide",
                    ErrorCode.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());
        if (!fournisseur.isPresent()) {
            log.warn("le client de l'Id {} n'a pas trouvé dans la BDD", dto.getFournisseur().getId());
            throw new EntityNotFoundException
                    ("Aucun fournisseur de l'ID"
                            + dto.getFournisseur().getId() + "existe dans la BDD", ErrorCode.FOURNISSEUR_NOT_FOUND);
        }
        List<String> articleError = new ArrayList<>();
        if (dto.getLigneCommandeFournisseurs() != null) {
            dto.getLigneCommandeFournisseurs().forEach(LignFr -> {
                if (LignFr.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(LignFr.getArticle().getId());
                    if (article.isEmpty()) {
                        articleError.add("l'article de L'ID" + LignFr.getArticle().getId() + "n'exsite pas dans la BDD");
                    }
                }
            });
        }
            if (!articleError.isEmpty()) {
                log.warn("");
                throw new InvalidEntityException("l'article n'est pas existe dans la BDD",
                        ErrorCode.ARTICLE_NOT_VALID, articleError);
            }
            CommandeFournisseur saveFR = commandeFournisseurRepository.
                    save(CommandeFournisseurDto.toEntity(dto));
            if (dto.getLigneCommandeFournisseurs() != null) {
                dto.getLigneCommandeFournisseurs().forEach(LignFr -> {
                    LigneCommandeFournisseur ligneCommandeFournisseur =
                            LigneCommandeFournisseurDto.toEntity(LignFr);
                    ligneCommandeFournisseur.setCommandeFournisseur(saveFR);
                    ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
                });
            }
            return CommandeFournisseurDto.fromEntity(saveFR);
        }




    @Override
    public CommandeFournisseurDto findById(Integer id) {
    if(id==null){
        log.error("l'id de la commande fournisseur est vide");
        return null;
    }
        return commandeFournisseurRepository.findById(id).
                map(CommandeFournisseurDto::fromEntity).orElseThrow
                (()->new EntityNotFoundException
                        ("la commande fournisseur de l'id"+id+"n'existe pas dans la BDD",
                                ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public CommandeFournisseurDto findByCodeComFournisseur(String code) {
    if(!StringUtils.hasLength(code)){
        log.error("le code de la commande fournisseur n'est pas valide");

    }
        return commandeFournisseurRepository.findByCodef(code).map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(()->new
                        EntityNotFoundException("la commande fournisseur de code " +
                        ""+code+"n'existe pas dans la BDD",ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream().
                map(CommandeFournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteComFournisseur(Integer id) {

    commandeFournisseurRepository.deleteById(id);

    }
}
