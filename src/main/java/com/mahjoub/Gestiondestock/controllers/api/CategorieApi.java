package com.mahjoub.Gestiondestock.controllers.api;
import com.mahjoub.Gestiondestock.DTO.ArticleDto;
import com.mahjoub.Gestiondestock.DTO.CategorieDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.mahjoub.Gestiondestock.utils.Constants.APP_ROOT;
@Api(value = APP_ROOT + "/categories")
public interface CategorieApi {

    @PostMapping(value = APP_ROOT + "/categories/create",consumes =
            MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "enregistrer une categorie ",notes = "Cette Methode permet d'enregistrer ou de modifier une categorie", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200  ,message = "cet objet categorie creer/modifier"),
            @ApiResponse(code = 400  ,message = "la categorie n'est pas valide")})
    CategorieDto saveCa(@RequestBody CategorieDto categorieDto);

    @GetMapping(value = APP_ROOT+"/categories/{idcategorie}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une categorie par son ID ",notes = "Cette Methode permet de chercher une categorie avec son identifiant", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200  ,message = "lacategorie est trouvé dans la BDD"),
            @ApiResponse(code = 404  ,message = "Aucune categorie trouvé dans la BDD avec cet ID")
    })
    CategorieDto findById(@PathVariable("idcategorie")Integer id);

    @GetMapping(value = APP_ROOT+"/categories/{codecategorie}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une categorie par son code ",notes = "Cette Methode permet de chercher une categorie avec son code", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200  ,message = "lacategorie est trouvé dans la BDD"),
            @ApiResponse(code = 404  ,message = "Aucune categorie trouvé dans la BDD avec cet code")
    })
    CategorieDto findByCodeCategorie(@PathVariable("codecategorie")String code);

    @GetMapping(value = APP_ROOT+"/categories/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "permet d'afficher la liste des categories dans la BDD ",notes = "Cette Methode permet d'afficher la liste des categorie qui se trouve dans la BDD", responseContainer = "List<CategorieDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200  ,message = "la liste categorie est trouvé dans la BDD"),
            @ApiResponse(code = 400  ,message = "la liste categorie est vide")
    })
    List<CategorieDto>findAll();

    @DeleteMapping(value = APP_ROOT+"/categories/delete/{id_categorie}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "supprimer  une categorie par son ID ",notes = "Cette Methode permet de supprimer une categorie avec son ID categorie")
    @ApiResponses(value = {
            @ApiResponse(code = 200  ,message = "la categorie est supprimé avec succé"),
            @ApiResponse(code = 404  ,message = "Aucune categorie trouvé dans la BDD ")
    })
    void deleteCategorie(@PathVariable("id_categorie")Integer id);
}
