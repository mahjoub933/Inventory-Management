package com.mahjoub.Gestiondestock.controllers.api;

import com.mahjoub.Gestiondestock.DTO.CommandeClientDto;
import com.mahjoub.Gestiondestock.DTO.CommandeFournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mahjoub.Gestiondestock.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/commandefounisseurs")
public interface CommandeFournisseurApi {

    @PostMapping( APP_ROOT +"/commandefournisseurs/create")
    ResponseEntity<CommandeFournisseurDto> save(@RequestBody CommandeFournisseurDto commandeFournisseurDto);

    @GetMapping(APP_ROOT+"/commandefournisseurs/{idcommandefournisseur}")
    ResponseEntity <CommandeFournisseurDto> findById( @PathVariable Integer idcommandefournisseur);

    @GetMapping(APP_ROOT +"/commandefournisseurs/{codecommandefournisseur}")
    ResponseEntity <CommandeFournisseurDto> findByCodecom(@PathVariable("codecommandefournisseur") String codefour);

    @GetMapping(APP_ROOT +"/commandefournisseurs/all")
    ResponseEntity <List<CommandeFournisseurDto>> findAll();

    @DeleteMapping( APP_ROOT + "/commandefournisseurs/delete/{idcommandefournisseur}")
    ResponseEntity delete(@PathVariable ("idcommandefournisseur")Integer id);

}

