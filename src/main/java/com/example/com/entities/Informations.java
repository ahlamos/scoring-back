package com.example.com.entities;

import java.util.Date;

public class Informations {
    private Long id;
    private  String nom;
    private  String civilite;
    private  String telephone;
    private  String email;
    private String CIN;
    private Date dateNaissance;
    private String adresse;

    public Informations(Long id, String nom, String civilite, String telephone, String email, String CIN, Date dateNaissance, String adresse) {
        this.id = id;
        this.nom = nom;
        this.civilite = civilite;
        this.telephone = telephone;
        this.email = email;
        this.CIN = CIN;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    public Informations() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
