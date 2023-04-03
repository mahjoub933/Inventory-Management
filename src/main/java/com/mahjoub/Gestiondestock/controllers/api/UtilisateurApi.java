package com.mahjoub.Gestiondestock.controllers.api;

;
import com.mahjoub.Gestiondestock.DTO.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mahjoub.Gestiondestock.utils.Constants.APP_ROOT;
@Api(value = APP_ROOT + "/user")
public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT+"/user/create",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto utilisateurDto);
    @GetMapping(value = APP_ROOT+"/user/{id_user}",produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable("id_user")Integer id);
    @GetMapping(value = APP_ROOT+"/user/{code_user}",produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findByCodeUtilisateur(@PathVariable("code_user")String code);
    @GetMapping(value = APP_ROOT+"/user/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();
    @DeleteMapping(value = APP_ROOT+"/user/delete/{id_user}",produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteUtilisateur(@PathVariable("id_user")Integer id);
}
