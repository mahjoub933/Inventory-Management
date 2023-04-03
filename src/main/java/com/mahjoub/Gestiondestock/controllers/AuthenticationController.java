package com.mahjoub.Gestiondestock.controllers;
import com.mahjoub.Gestiondestock.DTO.auth.AuthenticationRequest;
import com.mahjoub.Gestiondestock.DTO.auth.AuthenticationResponse;
import com.mahjoub.Gestiondestock.model.ModelUser;
import com.mahjoub.Gestiondestock.services.authSer.ApplicationUserDetailsService;
import com.mahjoub.Gestiondestock.services.authSer.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.mahjoub.Gestiondestock.utils.Constants.AUTHENTICATION_END_POINT;

@RestController
@RequestMapping(AUTHENTICATION_END_POINT)
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ApplicationUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil tokenUtil;

  @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                 request.getLogin(),
                 request.getPassword()
         ));
         final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());

         final String jwt = tokenUtil.generateToken((ModelUser)userDetails);

         return ResponseEntity.ok(AuthenticationResponse.builder().jwtToken(jwt).build());
    }
}
