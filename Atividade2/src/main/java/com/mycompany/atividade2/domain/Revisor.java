package com.mycompany.atividade2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Revisor extends Pessoa implements Serializable {
    
    private String nota;
    @OneToMany(cascade = {CascadeType.ALL})                
    private List<Publicacao> publicacoes = new ArrayList<>();
    
    public Revisor() {
    }

    public Revisor(String nota, String nome, Date dataNascimento) {
        super(nome, dataNascimento);
        this.nota = nota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }
    
}
