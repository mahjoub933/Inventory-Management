package com.mahjoub.Gestiondestock.controllers;

import com.mahjoub.Gestiondestock.DTO.ClientDto;
import com.mahjoub.Gestiondestock.controllers.api.ClientApi;
import com.mahjoub.Gestiondestock.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClientController implements ClientApi {

    private ClientService clientService;
@Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public ClientDto findByCodeClient(String code) {
        return clientService.findByCodeClient(code);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void deleteClients(Integer id) {
    clientService.deleteClient(id);

    }
}
