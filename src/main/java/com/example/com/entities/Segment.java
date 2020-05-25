package com.example.com.entities;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Segment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double debut;
    private double fin;
    @OneToOne(cascade = CascadeType.ALL)
    @RestResource(exported = false)
    private Notation notation;

    public Segment(double debut, double fin, Notation notations) {
        this.debut = debut;
        this.fin = fin;
        this.notation= notations;
    }

    public Segment(double debut, double fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public Segment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDebut() {
        return debut;
    }

    public void setDebut(double debut) {
        this.debut = debut;
    }

    public double getFin() {
        return fin;
    }

    public void setFin(double fin) {
        this.fin = fin;
    }

    public Notation getNotation() {
        return notation;
    }

    public void setNotation(Notation notation) {
        this.notation = notation;
    }

}
