package com.mahjoub.Gestiondestock.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahjoub.Gestiondestock.DAO.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder

public class ClientDto {

    private Integer id;

    private String codeClient;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photoc;

    private String email;

    private String numtel;

    private List<CommandeClientDto> commandeclient;

    public static ClientDto fromEntity(Client client){
        if(client==null){
            return null;
        }
        return ClientDto.builder().id(client.getId()).codeClient(client.getCodeClient()).nom(client.getNom()).prenom(client.
                getPrenom()).photoc(client.getPhotoc()).email(client.getEmail()).numtel(client.getNumtel())
                .build();
    }
    public static Client toEntity(ClientDto clientDto){
        if(clientDto==null){
            return null;
        }
        Client client=new Client();
        client.setId(clientDto.getId());
        client.setCodeClient(clientDto.getCodeClient());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setPhotoc(clientDto.getPhotoc());
        client.setEmail(clientDto.getEmail());
        client.setNumtel(clientDto.getNumtel());
        return client;
    }
}
