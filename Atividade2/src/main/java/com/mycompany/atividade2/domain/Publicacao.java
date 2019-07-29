package com.mycompany.atividade2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Publicacao implements Serializable{
    @Id
    @GeneratedValue
    private int codPublicacao;
    private String titulo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="escritor_Id")
    private Escritor escritor;
    
    @OneToMany
    @JoinColumn(name = "area_Id")
    private List<Object> areas = new ArrayList<Object>();

    public Publicacao() {
    }

    public Publicacao(int codPublicacao, String titulo) {
        this.codPublicacao = codPublicacao;
        this.titulo = titulo;
    }

    public int getCodPublicacao() {
        return codPublicacao;
    }

    public void setCodPublicacao(int codPublicacao) {
        this.codPublicacao = codPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Escritor getEscritor() {
        return escritor;
    }

    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }

    public List<Object> getAreas() {
        return areas;
    }

    public void setAreas(List<Object> areas) {
        this.areas = areas;
    }
    
    
}
