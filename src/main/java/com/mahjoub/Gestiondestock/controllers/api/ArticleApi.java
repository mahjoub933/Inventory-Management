package com.mahjoub.Gestiondestock.controllers.api;

import com.mahjoub.Gestiondestock.DTO.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import static com.mahjoub.Gestiondestock.utils.Constants.APP_ROOT;
import java.util.List;

@Api(APP_ROOT + "/article")
public interface ArticleApi {

@PostMapping(value = APP_ROOT +"/article/create",consumes = MediaType.APPLICATION_JSON_VALUE
        ,produces = MediaType.APPLICATION_JSON_VALUE)

@ApiOperation(value = "enregistrer un article ",notes = "Cette Methode permet d'enregistrer ou de modifier un article", response = ArticleDto.class)
@ApiResponses(value = {
        @ApiResponse(code = 200  ,message = "cet objet article creer/modifier"),
        @ApiResponse(code = 400  ,message = "l'article n'est pas valide")})
   ArticleDto saveA( @RequestBody ArticleDto articleDto);

@GetMapping(value=APP_ROOT+"/article/{idarticle}",produces = MediaType.APPLICATION_JSON_VALUE)
@ApiOperation(value = "rechercher un article par son ID ",notes = "Cette Methode permet de chercher un article avec son identifiant", response = ArticleDto.class)
@ApiResponses(value = {
        @ApiResponse(code = 200  ,message = "l'article est trouvé dans la BDD"),
        @ApiResponse(code = 404  ,message = "Aucun article trouvé dans la BDD avec cet ID")
})
    ArticleDto findById(@PathVariable("idarticle") Integer id);

@GetMapping(value=APP_ROOT+"/article/{codearticle}",produces = MediaType.APPLICATION_JSON_VALUE)
@ApiOperation(value = "rechercher un article par son code ",notes = "Cette Methode permet de chercher un article avec son code article", response = ArticleDto.class)
@ApiResponses(value = {
        @ApiResponse(code = 200  ,message = "l'article est trouvé dans la BDD"),
        @ApiResponse(code = 404  ,message = "Aucun article trouvé dans la BDD avec cet code")
})
    ArticleDto findByCodeArticle(@PathVariable("codearticle") String code);

@GetMapping(value=APP_ROOT+"/article/all",produces = MediaType.APPLICATION_JSON_VALUE)
@ApiOperation(value = "permet d'afficher la liste des articles dans la BDD ",notes = "Cette Methode permet d'afficher la liste des articles qui se trouve dans la BDD", responseContainer = "List<ArticleDto>")
@ApiResponses(value = {
        @ApiResponse(code = 200  ,message = "la liste article est trouvé dans la BDD"),
        @ApiResponse(code = 400  ,message = "la liste article est vide")
})
    List<ArticleDto> findAll();


@DeleteMapping (value=APP_ROOT+"/article/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiOperation(value = "supprimer  un article par son ID ",notes = "Cette Methode permet de supprimer un article avec son ID article",response = ArticleDto.class)
@ApiResponses(value = {
        @ApiResponse(code = 200  ,message = "l'article est supprimé avec succé"),
        @ApiResponse(code = 404  ,message = "Aucun article trouvé dans la BDD ")
})
    void delete(@PathVariable("id") Integer id);

}
