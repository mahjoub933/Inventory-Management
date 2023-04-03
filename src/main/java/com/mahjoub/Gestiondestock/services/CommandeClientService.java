package com.mahjoub.Gestiondestock.services;


import com.mahjoub.Gestiondestock.DTO.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto save(CommandeClientDto dto);
    CommandeClientDto findById(Integer id);
    CommandeClientDto findByCodeComClient(String code);
    List<CommandeClientDto> findAll();
    void deleteComClient(Integer id);
}
