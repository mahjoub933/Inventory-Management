package com.mahjoub.Gestiondestock.DTO;





import com.mahjoub.Gestiondestock.DAO.CommandeClient;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder
public class CommandeClientDto {

    private Integer id;

    private String codecom;

    private Instant datecom;

    private ClientDto clients;

    private List<LigneCommandeClientDto> lignecommandeclient;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient){
        if(commandeClient==null){
            return null;
        }
        return CommandeClientDto.builder().id(commandeClient.getId()).codecom(commandeClient.getCodecom())
                .datecom(commandeClient.getDatecom()).build();

    }
    public static CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if(commandeClientDto==null){
            return null;
        }
        CommandeClient commandeClient=new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCodecom(commandeClientDto.getCodecom());
        commandeClient.setDatecom(commandeClientDto.getDatecom());
        return commandeClient;
    }

}
