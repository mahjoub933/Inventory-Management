package com.mahjoub.Gestiondestock.controllers.api;



import com.mahjoub.Gestiondestock.DTO.EntrepriseDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mahjoub.Gestiondestock.utils.Constants.APP_ROOT;
@Api(value = APP_ROOT + "/entreprises")
public interface EntrepriseApi {
    @PostMapping(value = APP_ROOT+"/entreprises/create",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto entrepriseDto);
    @GetMapping(value = APP_ROOT+"/entreprises/{id_entreprise}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("id_entreprise")Integer id);
    @GetMapping(value = APP_ROOT+"/entreprises/{code_entreprise}",produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findByCodeEntreprise(@PathVariable("code_entreprise")String code);
    @GetMapping(value = APP_ROOT+"/entreprises/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();
    @DeleteMapping(value = APP_ROOT+"/entreprises/delete/{id_entreprise}",produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteEntreprise(@PathVariable("id_entreprise")Integer id);
}
