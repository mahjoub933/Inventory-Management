package com.mahjoub.Gestiondestock.controllers.api;
import static com.mahjoub.Gestiondestock.utils.Constants.APP_ROOT;

import com.mahjoub.Gestiondestock.DTO.ClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = APP_ROOT + "/clients")
public interface ClientApi {

    @PostMapping(value = APP_ROOT+"/clients/create",consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto clientDto);
    @GetMapping(value = APP_ROOT+"/clients/{idclient}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("idclient")Integer id);
    @GetMapping(value = APP_ROOT+"/clients/{codeclient}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findByCodeClient(@PathVariable("codeclient")String code);
    @GetMapping(value = APP_ROOT+"/clients/all/",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto>findAll();
    @DeleteMapping(value = APP_ROOT+"/clients/delete/{idclient}",produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteClients(@PathVariable("idclient")Integer id);

}
