package com.mahjoub.Gestiondestock.services;

import com.mahjoub.Gestiondestock.DTO.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto clientDto);
    ClientDto findById(Integer id);
    ClientDto findByCodeClient(String code);
    List<ClientDto> findAll();
    void deleteClient(Integer id);
}
