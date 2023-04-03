package com.mahjoub.Gestiondestock.services.impl;

import com.mahjoub.Gestiondestock.DAO.Article;
import com.mahjoub.Gestiondestock.DAO.Client;
import com.mahjoub.Gestiondestock.DAO.CommandeClient;
import com.mahjoub.Gestiondestock.DAO.LigneCommandeClient;
import com.mahjoub.Gestiondestock.DTO.CommandeClientDto;
import com.mahjoub.Gestiondestock.DTO.LigneCommandeClientDto;
import com.mahjoub.Gestiondestock.Exceptions.EntityNotFoundException;
import com.mahjoub.Gestiondestock.Exceptions.ErrorCode;
import com.mahjoub.Gestiondestock.Exceptions.InvalidEntityException;
import com.mahjoub.Gestiondestock.Repository.LigneCommandeClientRepository;
import com.mahjoub.Gestiondestock.validators.CommandeClientValidator;
import com.mahjoub.Gestiondestock.Repository.ArticleRepository;
import com.mahjoub.Gestiondestock.Repository.ClientRepository;
import com.mahjoub.Gestiondestock.Repository.CommandeClientRepository;
import com.mahjoub.Gestiondestock.services.CommandeClientService;
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
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;
    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository, ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
       List<String>errors=CommandeClientValidator.validate(dto);


       if(!errors.isEmpty()){
           log.error("la commande client n'est pas valide");
           throw new InvalidEntityException
                   ("la commande client n'est pas valide ", ErrorCode.COMMANDE_CLIENT_NOT_VALID,errors);
       }
       Optional<Client> client= clientRepository.findById(dto.getClients().getId());
       if(!client.isPresent()){
           log.warn("le client de l'Id {} n'a pas trouvé dans la BDD",dto.getClients().getId());
           throw new EntityNotFoundException
                   ("Aucun client avec L'ID"+dto.getClients().getId()+
                           "n'a été trouvé dans la BDD",ErrorCode.CLIENT_NOT_FOUND);
       }
       List<String> articleErrors= new ArrayList<>();
       if(dto.getLignecommandeclient()!=null) {
           dto.getLignecommandeclient().forEach(LigneClt -> {
               if (LigneClt.getArticle() != null) {
                   Optional<Article> article = articleRepository.findById(LigneClt.getArticle().getId());
                   if (article.isEmpty()) {
                       articleErrors.add("L'article de code " + LigneClt.getArticle().getId() + "n'existe pas ");
                   }
               }
           });
       }
       if (!articleErrors.isEmpty()){
           log.warn("");
           throw new InvalidEntityException
                   ("l'article n'est pas existe dans la BDD",ErrorCode.ARTICLE_NOT_FOUND,articleErrors);
       }
        CommandeClient saveComClt=commandeClientRepository.save(CommandeClientDto.toEntity(dto));
       if(dto.getLignecommandeclient()!=null){
           dto.getLignecommandeclient().forEach(LigneClt->{
               LigneCommandeClient ligneCommandeClient= LigneCommandeClientDto.toEntity(LigneClt);
               ligneCommandeClient.setCommandeclients(saveComClt);
               ligneCommandeClientRepository.save(ligneCommandeClient);
           });
       }

        return CommandeClientDto.fromEntity(saveComClt);
    }


    @Override
    public CommandeClientDto findById(Integer id) {
        if(id==null){
            log.error("l'id de commande client est null");
        }
        return commandeClientRepository.findById(id).map(CommandeClientDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException
                        ("la commande client de l'ID"+id+
                                "n'est pas existe dans la BDD",ErrorCode.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public CommandeClientDto findByCodeComClient(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("l'id de commande client est null");
        }
        return commandeClientRepository.findByCodecom(code).map(CommandeClientDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException
                        ("la commande client de l'ID"+code+
                                "n'est pas existe dans la BDD",ErrorCode.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream().map(CommandeClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteComClient(Integer id) {
        commandeClientRepository.deleteById(id);

    }
}
