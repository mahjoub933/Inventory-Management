package com.mahjoub.Gestiondestock.DTO.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {

    private String jwtToken;
}
