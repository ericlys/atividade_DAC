package com.mycompany.atividade2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Escritor extends Pessoa implements Serializable {
    
    private int premios;
    @OneToMany(
            mappedBy = "escritor",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Publicacao> publicacoes = new ArrayList<>();

    public Escritor() {
    }

    public Escritor(int premios, String nome, Date dataNascimento) {
        super(nome, dataNascimento);
        this.premios = premios;
    }

    public int getPremios() {
        return premios;
    }

    public void setPremios(int premios) {
        this.premios = premios;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }
    
}
