package com.example.com.security;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class KeycloakSpringSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }


    protected void configure(HttpSecurity http) throws Exception{
        super.configure(http);
        http.authorizeRequests().antMatchers("/calculerScore/**").hasAuthority("charge-instruction").
                antMatchers("/majClient/**").hasAuthority("directeur-agence").
                antMatchers("/ajouterClient").authenticated().
                antMatchers("/clients").authenticated().
                antMatchers("/rules").authenticated().
                antMatchers("/conditionses").authenticated().
                antMatchers("/segments").authenticated().
                antMatchers("/segments?projection=segNot").authenticated().
                antMatchers("/notations").authenticated().
                antMatchers("/infoClients/**").hasAuthority("charge-instruction").
                antMatchers("/majSegments").hasAuthority("admin").
                antMatchers("/demandesCredits").authenticated().
                antMatchers("/updateStatut/**").authenticated();

        http.cors();
        http.csrf().disable();
    }
}
