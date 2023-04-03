package com.mahjoub.Gestiondestock.services.authSer;

import com.mahjoub.Gestiondestock.DAO.Utilisateur;
import com.mahjoub.Gestiondestock.DTO.UtilisateurDto;
import com.mahjoub.Gestiondestock.Exceptions.EntityNotFoundException;
import com.mahjoub.Gestiondestock.Exceptions.ErrorCode;
import com.mahjoub.Gestiondestock.Repository.UtilisateurRepository;
import com.mahjoub.Gestiondestock.model.ModelUser;
import com.mahjoub.Gestiondestock.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private UtilisateurService u;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UtilisateurDto utilisateur =u.findByEmailU(username);
       /* Utilisateur utilisateur= u.findByEmailU(username).orElseThrow(()->
            new EntityNotFoundException ("l'email n'est pas valide ", ErrorCode.UTILISATEUR_NOT_FOUND)
        );*/
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
      utilisateur.getRoles().forEach(role->authorities.add(new SimpleGrantedAuthority(role.getNomR())));
        return new ModelUser(utilisateur.getEmailU(),utilisateur.getMotdepasse(), utilisateur.getEntreprise().getId(),authorities);
    }
}
