package com.mycompany.atividade2.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Area implements Serializable {
    @Id
    @GeneratedValue
    private int cod;
    private String nome;

    public Area() {
    }

    public Area(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
