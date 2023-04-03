package com.mahjoub.Gestiondestock.config;

import com.mahjoub.Gestiondestock.services.authSer.JwtUtil;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApplicationRequestFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil util;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authheader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;
        String idEntreprise= null;

        if(StringUtils.hasLength(authheader)&& authheader.startsWith("Bearer ")){
            jwt = authheader.substring(7);
            username = util.extractUsername(jwt);
            idEntreprise= util.extractIdEntreprise(jwt);
        }
        if(username != null && SecurityContextHolder.getContext().getAuthentication()== null){

            UserDetails userDetails= userDetailsService.loadUserByUsername(username);
            if(util.validateToken(jwt,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails,null,
                                userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        request
                ));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        MDC.put("idEntreprise",idEntreprise);
        filterChain.doFilter(request,response);
    }
}
