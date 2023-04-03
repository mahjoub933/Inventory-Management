package com.mahjoub.Gestiondestock.config;
import com.mahjoub.Gestiondestock.services.authSer.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private ApplicationRequestFilter applicationRequestFilter;

    private ApplicationUserDetailsService applicationUserDetailsService;
    @Autowired
    public SecurityConfiguration(ApplicationRequestFilter applicationRequestFilter,ApplicationUserDetailsService applicationUserDetailsService) {
        this.applicationUserDetailsService = applicationUserDetailsService;
        this.applicationRequestFilter = applicationRequestFilter;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(applicationUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

 public final   String [] PUBLIC_ENDPOINTS= {"/**/authenticate",
                "/**/entreprises/create",
                        "/v2/api-docs",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**"};



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers(PUBLIC_ENDPOINTS)
                .permitAll()
                 .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);//RESTFULL:on garde pas le status du client au niveau de notre api

        http.addFilterBefore(applicationRequestFilter,UsernamePasswordAuthenticationFilter.class);//cad avant d'executé la requete merci d'executé se filtre la que nous avons creer sur applicationrequestfilter d'etuliser UsernamePasswordAuthenticationFilter
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }
}
/* commentaires
les etapes pour faire la securité:
1-ajout de dependance security dans pom.xml
2-creer une class SecurityConfiguration extends WebSecurityConfigurerAdapter
2.1-on ajoute @EnableWebSecurity pour activer la securité
3-on doit definir la configuration "d'url" ensuite on doit definir la configuration :AuthenticationManager authenticationManager() throws Exception et n'oublier pas de redefinir avec @Bean
4-public PasswordEncoder passwordEncoder()*/