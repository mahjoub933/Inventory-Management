package com.mahjoub.Gestiondestock.controllers.api;


import com.mahjoub.Gestiondestock.DTO.FournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mahjoub.Gestiondestock.utils.Constants.APP_ROOT;
@Api(value = APP_ROOT + "/fournisseurs")
public interface FournisseurApi {
    @PostMapping(value = APP_ROOT+"/fournisseurs/create",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);
    @GetMapping(value = APP_ROOT+"/fournisseurs/{id_fournissuer}",produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findByIdF(@PathVariable("id_fournissuer")Integer id);
    @GetMapping(value = APP_ROOT+"/fournisseurs/{code_fournissuer}",produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findByCodeFournisseur(@PathVariable("code_fournissuer")String code);
    @GetMapping(value = APP_ROOT + "/fournisseurs/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();
    @DeleteMapping(value = APP_ROOT+"/fournisseurs/delete/{id_fournissuer}",produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteFournisseur(@PathVariable("id_fournissuer")Integer id);
}
