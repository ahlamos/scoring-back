package com.example.com.configuration;


import com.example.com.entities.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class SpringDataRestCustomization extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Client.class);
        config.exposeIdsFor(InfoClient.class);
        config.exposeIdsFor(Segment.class);
        config.exposeIdsFor(Notation.class);
        config.exposeIdsFor(Rule.class);
        config.exposeIdsFor(Conditions.class);
        config.exposeIdsFor(DemandeCredit.class);
    }
}

