package com.example.com.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

@Projection(name="segNot", types= {Segment.class})
public interface ClientProjection {
    Long getId();
    String getNom();
    String getCivilite();
    String getTelephone();
    String getEmail();
    String getCin();
    Date getDateNaissance();
    InfoClient getInfoClient();
    Notation getNotation();
    List<DemandeCredit> getDemandeCredits();



}
