/**
 * Copyright 2018 Gabriel Stelmach
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to 
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the 
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR 
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Licensed under the MIT license: https://opensource.org/licenses/MIT
 */
package com.example.com.entities;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Client implements Serializable
{
    /**
     * Product name.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom;
    private  String civilite;
    private  String telephone;
    private  String email;
    private String CIN;
    private  Date dateNaissance;
    @RestResource(exported = false)
    @OneToOne(cascade = CascadeType.ALL)
    private InfoClient infoClient;
    private double score;
    @ManyToOne(cascade = CascadeType.ALL)
    @RestResource(exported = false)
    private Notation notation;
    @OneToMany(cascade = CascadeType.ALL)
    @RestResource(exported = false)
    private List<DemandeCredit> demandeCredits = new ArrayList<DemandeCredit>();
    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public Notation getNotation() {
        return notation;
    }

    public void setNotation(Notation notation) {
        this.notation = notation;
    }



    public Client(long id, String nom, String civilite, String telephone, String email, String CIN, Date dateNaissance) {
        this.nom = nom;
        this.civilite = civilite;
        this.telephone = telephone;
        this.email = email;
        this.CIN = CIN;
        this.dateNaissance = dateNaissance;
        this.id=id;
    }

    public Client(String nom, String civilite, String telephone, String email, String CIN, Date dateNaissance) {
        this.nom = nom;
        this.civilite = civilite;
        this.telephone = telephone;
        this.email = email;
        this.CIN = CIN;
        this.dateNaissance = dateNaissance;
    }

    public void discount(double percent)
    {
        score = (score + percent);
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    public InfoClient getInfoClient() {
        return infoClient;
    }

    public void setInfoClient(InfoClient infoClient) {
        this.infoClient = infoClient;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<DemandeCredit> getDemandeCredits() {
        return demandeCredits;
    }

    public void setDemandeCredits(List<DemandeCredit> demandeCredits) {
        this.demandeCredits = demandeCredits;
    }
}
