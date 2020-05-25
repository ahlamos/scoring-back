package com.example.com.entities;

public class ResultatScore {
    private Notation notation;
    private Long identidicateur;

    public ResultatScore() {
    }

    public ResultatScore(Notation notation, Long identidicateur) {
        this.notation = notation;
        this.identidicateur = identidicateur;
    }

    public Notation getNotation() {
        return notation;
    }

    public void setNotation(Notation notation) {
        this.notation = notation;
    }

    public Long getIdentidicateur() {
        return identidicateur;
    }

    public void setIdentidicateur(Long identidicateur) {
        this.identidicateur = identidicateur;
    }
}
