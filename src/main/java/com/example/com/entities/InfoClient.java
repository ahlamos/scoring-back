package com.example.com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class InfoClient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String natureProjet;
    private String situationMaritale;
    private double salaire;
    private int nbEnfant;
    private double tauxEndettement;
    private double credit;
    private String documentSejour;
    private String statutLogement;
    private Long dureeLogement;
    private Long nbEmprunteur;
    private String statutProfesionnel;
    private String typeContrat;
    private String classificationContrat;
    private long dureeContrat;
    private String adresse;
    public void discount(int percent)
    {
        nbEnfant = (nbEnfant + percent);
    }


    public InfoClient(String natureProjet, String situationMaritale, int nbEnfant, double tauxEndettement, double credit, String documentSejour, String statutLogement, Long dureeLogement, Long nbEmprunteur, String statutProfesionnel, String typeContrat, String classificationContrat, long dureeContrat,String adresse) {
        this.natureProjet = natureProjet;
        this.situationMaritale = situationMaritale;
        this.nbEnfant = nbEnfant;
        this.tauxEndettement = tauxEndettement;
        this.credit = credit;
        this.documentSejour = documentSejour;
        this.statutLogement = statutLogement;
        this.dureeLogement = dureeLogement;
        this.nbEmprunteur = nbEmprunteur;
        this.statutProfesionnel = statutProfesionnel;
        this.typeContrat = typeContrat;
        this.classificationContrat = classificationContrat;
        this.dureeContrat = dureeContrat;
        this.adresse=adresse;
    }

    public InfoClient(String situationMaritale, double salaire, int nbEnfant) {
        this.situationMaritale = situationMaritale;
        this.salaire = salaire;
        this.nbEnfant = nbEnfant;
    }


    public InfoClient(String natureProjet)
    {
        this.natureProjet = natureProjet;
    }

    public InfoClient() {
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getNatureProjet() {
        return natureProjet;
    }

    public void setNatureProjet(String natureProjet) {
        this.natureProjet = natureProjet;
    }

    public String getSituationMaritale() {
        return situationMaritale;
    }

    public void setSituationMaritale(String situationMaritale) {
        this.situationMaritale = situationMaritale;
    }

    public String getDocumentSejour() {
        return documentSejour;
    }

    public void setDocumentSejour(String documentSejour) {
        this.documentSejour = documentSejour;
    }



    public String getStatutLogement() {
        return statutLogement;
    }

    public void setStatutLogement(String statutLogement) {
        this.statutLogement = statutLogement;
    }

    public Long getDureeLogement() {
        return dureeLogement;
    }

    public void setDureeLogement(Long dureeLogement) {
        this.dureeLogement = dureeLogement;
    }

    public Long getNbEmprunteur() {
        return nbEmprunteur;
    }

    public void setNbEmprunteur(Long nbEmprunteur) {
        this.nbEmprunteur = nbEmprunteur;
    }

    public String getStatutProfesionnel() {
        return statutProfesionnel;
    }

    public void setStatutProfesionnel(String statutProfesionnel) {
        this.statutProfesionnel = statutProfesionnel;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public String getClassificationContrat() {
        return classificationContrat;
    }

    public void setClassificationContrat(String classificationContrat) {
        this.classificationContrat = classificationContrat;
    }

    public long getDureeContrat() {
        return dureeContrat;
    }

    public void setDureeContrat(long dureeContrat) {
        this.dureeContrat = dureeContrat;
    }

    public double getTauxEndettement() {
        return tauxEndettement;
    }

    public void setTauxEndettement(double tauxEndettement) {
        this.tauxEndettement = tauxEndettement;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }


    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public int getNbEnfant() {
        return nbEnfant;
    }

    public void setNbEnfant(int nbEnfant) {
        this.nbEnfant = nbEnfant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
