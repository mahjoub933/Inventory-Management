package com.mahjoub.Gestiondestock.services.impl;

import com.mahjoub.Gestiondestock.DAO.Client;
import com.mahjoub.Gestiondestock.DTO.ClientDto;
import com.mahjoub.Gestiondestock.Exceptions.EntityNotFoundException;
import com.mahjoub.Gestiondestock.Exceptions.ErrorCode;
import com.mahjoub.Gestiondestock.Exceptions.InvalidEntityException;
import com.mahjoub.Gestiondestock.Repository.ClientRepository;
import com.mahjoub.Gestiondestock.services.ClientService;
import com.mahjoub.Gestiondestock.validators.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    @Autowired
    public CientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String>errors=ClientValidator.validate(clientDto);
        if(!errors.isEmpty()){
            log.error("le client n'est pas valide",clientDto);
            throw new InvalidEntityException("le client n'est pas valide", ErrorCode.CLIENT_NOT_VALID,errors);

        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id==null){
            log.error("id de client est null");
            return null;
        }

       /* Optional<Client> client= clientRepository.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get()))
                .orElseThrow(()->new EntityNotFoundException
                        ("Aucun client de l'Id"+id+"trouvé dans la BDD",ErrorCode.CLIENT_NOT_FOUND));*/
        //Utilisation de la methode de reference (ClientDto::fromEntity)
       return clientRepository.findById(id).map(ClientDto::fromEntity).orElseThrow(()->new EntityNotFoundException
                ("Aucun client de l'Id"+id+"trouvé dans la BDD",ErrorCode.CLIENT_NOT_FOUND));

    }

    @Override
    public ClientDto findByCodeClient(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("code de client est nulle");
            return null;
        }
        Optional<Client> client=clientRepository.findByCodeClient(code);
        return Optional.of(ClientDto.fromEntity(client.get()))
                .orElseThrow(()->new EntityNotFoundException
                        ("Aucun client a le code "+code+"trouvé dans la BDD",ErrorCode.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteClient(Integer id) {
        if(id==null){
            log.error("l'ID client est nulle");
            return;
        }
        clientRepository.deleteById(id);

    }
}
