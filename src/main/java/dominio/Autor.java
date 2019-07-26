/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import javax.xml.crypto.Data;

/**
 *
 * @author kaique
 */
public class Autor extends Pessoa{
    
     public Autor(String nome, String cpf, int idade, Data dataNascimento, Endereco endereco) {
        super(nome, cpf, idade, dataNascimento, endereco);
    }
    
    private String instituicaoVinculada ;

   
}
