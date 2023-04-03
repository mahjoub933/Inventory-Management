package com.mahjoub.Gestiondestock.controllers.api;


import com.mahjoub.Gestiondestock.DTO.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mahjoub.Gestiondestock.utils.Constants.APP_ROOT;
import java.util.List;
@Api(APP_ROOT +"/commandeclients")
public interface CommandeClientApi {

    @PostMapping( APP_ROOT +"/commandeclients/create")
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto commandeClientDto);

    @GetMapping(APP_ROOT+"/commandeclients/{idcommandeclient}")
    ResponseEntity <CommandeClientDto> findById( @PathVariable Integer idcommandeclient);

    @GetMapping(APP_ROOT +"/commandeclients/{codecommandeclient}")
    ResponseEntity <CommandeClientDto> findByCodecom(@PathVariable("codecommandeclient") String codecom);

    @GetMapping(APP_ROOT +"/commandeclients/all")
    ResponseEntity <List<CommandeClientDto>> findAll();

    @DeleteMapping ( APP_ROOT + "/commandeclients/delete/{idcommandeclient}")
    ResponseEntity delete(@PathVariable ("idcommandeclient")Integer id);

}
