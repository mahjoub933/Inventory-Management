package com.mahjoub.Gestiondestock.controllers;

import com.mahjoub.Gestiondestock.DTO.CommandeClientDto;
import com.mahjoub.Gestiondestock.controllers.api.CommandeClientApi;
import com.mahjoub.Gestiondestock.services.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommandeClientController implements CommandeClientApi {
    private CommandeClientService commandeClientService;

    @Autowired
    public CommandeClientController(CommandeClientService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }

    @Override
    public ResponseEntity<CommandeClientDto> save(CommandeClientDto commandeClientDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commandeClientService.save(commandeClientDto));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findById(Integer id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(commandeClientService.findById(id));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findByCodecom(String codecom) {
        return  ResponseEntity.status(HttpStatus.OK).body(commandeClientService.findByCodeComClient(codecom));
    }

    @Override
    public ResponseEntity<List<CommandeClientDto>> findAll() {
        return  ResponseEntity.status(HttpStatus.OK).body(commandeClientService.findAll());
    }



    @Override
    public ResponseEntity delete(Integer id) {
        commandeClientService.deleteComClient(id);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
