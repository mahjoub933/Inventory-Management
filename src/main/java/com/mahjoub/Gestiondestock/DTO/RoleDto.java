package com.mahjoub.Gestiondestock.DTO;

import com.mahjoub.Gestiondestock.DAO.Role;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class RoleDto {

    private Integer id;

    private String nomR;

    private UtilisateurDto utilisateur;

    public static RoleDto fromEntity(Role role){
        if(role==null){
            return null;

        }
        return RoleDto.builder().id(role.getId()).nomR(role.getNomR()).utilisateur(UtilisateurDto.fromEntity(role.getUtilisateur())).build();
    }

    public static Role toEntity(RoleDto roleDto){
        if(roleDto==null){
            return null;
        }
        Role role= new Role();
        role.setId(roleDto.getId());
        role.setNomR(roleDto.getNomR());

        return role;
    }
}
