package com.mahjoub.Gestiondestock.controllers;

import com.mahjoub.Gestiondestock.DTO.CommandeFournisseurDto;
import com.mahjoub.Gestiondestock.controllers.api.CommandeFournisseurApi;
import com.mahjoub.Gestiondestock.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

    private CommandeFournisseurService commandeFournisseurService;
@Autowired
    public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService) {
        this.commandeFournisseurService = commandeFournisseurService;
    }

    @Override
    public ResponseEntity<CommandeFournisseurDto> save(CommandeFournisseurDto commandeFournisseurDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commandeFournisseurService.save(commandeFournisseurDto));
    }

    @Override
    public ResponseEntity<CommandeFournisseurDto> findById(Integer idcommandefournisseur) {
        return ResponseEntity.status(HttpStatus.FOUND).body(commandeFournisseurService.findById(idcommandefournisseur));
    }

    @Override
    public ResponseEntity<CommandeFournisseurDto> findByCodecom(String codefour) {
        return ResponseEntity.status(HttpStatus.OK).body(commandeFournisseurService.findByCodeComFournisseur(codefour));
    }

    @Override
    public ResponseEntity<List<CommandeFournisseurDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(commandeFournisseurService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        commandeFournisseurService.deleteComFournisseur(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
