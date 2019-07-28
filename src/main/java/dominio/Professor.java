/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

/**
 *
 * @author kaique
 */
@Entity
public class Professor extends Pessoa implements Serializable{
    
    @ElementCollection
    @CollectionTable(name = "Telefones")
   private List<Telefone> telefones;
    private double salario;

    public Professor(List<Telefone> telefones, double salario, String nome, String cpf, int idade, Date dataNascimento, Endereco endereco) {
        super(nome, cpf, idade, dataNascimento, endereco);
        this.telefones = telefones;
        this.salario = salario;
    }

    public Professor() {
      
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Professor{" + "salario=" + salario + '}';
    }
    
    
    
}
