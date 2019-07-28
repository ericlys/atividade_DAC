/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.xml.crypto.Data;

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

    public Professor(int id, String nome, String cpf, int idade, Data dataNascimento, Endereco endereco) {
        super(id, nome, cpf, idade, dataNascimento, endereco);
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
