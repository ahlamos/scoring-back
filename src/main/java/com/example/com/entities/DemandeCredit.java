package com.example.com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DemandeCredit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificateur;
    private Date dateDemande;
    private String statut;
    private double montantProjet;
    private long dureeRemboursement;
    private String natureProjet;
    private double montantMensuel;
    private double taeg;
    private double montantTotalDu;
    private double assurance;
    private double tauxEndettement;
    private double sommeChargeMensuelle;
    private double sommeCredit;
    private String notation;
    private double revenuMensuelTotal;


    public double getMontantProjet() {
        return montantProjet;
    }

    public void setMontantProjet(double montantProjet) {
        this.montantProjet = montantProjet;
    }

    public long getDureeRemboursement() {
        return dureeRemboursement;
    }

    public void setDureeRemboursement(long dureeRemboursement) {
        this.dureeRemboursement = dureeRemboursement;
    }

    public String getNatureProjet() {
        return natureProjet;
    }

    public void setNatureProjet(String natureProjet) {
        this.natureProjet = natureProjet;
    }

    public double getMontantMensuel() {
        return montantMensuel;
    }

    public void setMontantMensuel(double montantMensuel) {
        this.montantMensuel = montantMensuel;
    }

    public double getTaeg() {
        return taeg;
    }

    public void setTaeg(double taeg) {
        this.taeg = taeg;
    }

    public double getMontantTotalDu() {
        return montantTotalDu;
    }

    public void setMontantTotalDu(double montantTotalDu) {
        this.montantTotalDu = montantTotalDu;
    }

    public double getAssurance() {
        return assurance;
    }

    public void setAssurance(double assurance) {
        this.assurance = assurance;
    }

    public double getTauxEndettement() {
        return tauxEndettement;
    }

    public void setTauxEndettement(double tauxEndettement) {
        this.tauxEndettement = tauxEndettement;
    }

    public double getSommeChargeMensuelle() {
        return sommeChargeMensuelle;
    }

    public void setSommeChargeMensuelle(double sommeChargeMensuelle) {
        this.sommeChargeMensuelle = sommeChargeMensuelle;
    }

    public double getSommeCredit() {
        return sommeCredit;
    }

    public void setSommeCredit(double sommeCredit) {
        this.sommeCredit = sommeCredit;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public double getRevenuMensuelTotal() {
        return revenuMensuelTotal;
    }

    public void setRevenuMensuelTotal(double revenuMensuelTotal) {
        this.revenuMensuelTotal = revenuMensuelTotal;
    }

    public DemandeCredit() {
    }

    public DemandeCredit(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public DemandeCredit( Date dateDemande, String statut, double montantProjet, long dureeRemboursement, String natureProjet, double montantMensuel, double taeg, double montantTotalDu, double assurance, double tauxEndettement, double sommeChargeMensuelle, double sommeCredit, String notation) {
        this.dateDemande = dateDemande;
        this.statut = statut;
        this.montantProjet = montantProjet;
        this.dureeRemboursement = dureeRemboursement;
        this.natureProjet = natureProjet;
        this.montantMensuel = montantMensuel;
        this.taeg = taeg;
        this.montantTotalDu = montantTotalDu;
        this.assurance = assurance;
        this.tauxEndettement = tauxEndettement;
        this.sommeChargeMensuelle = sommeChargeMensuelle;
        this.sommeCredit = sommeCredit;
        this.notation = notation;
    }

    public Long getIdentificateur() {
        return identificateur;
    }

    public void setIdentificateur(Long  identificateur) {
        this.identificateur = identificateur;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
