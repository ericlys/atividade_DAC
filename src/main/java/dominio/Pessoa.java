/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.xml.crypto.Data;

/**
 *
 * @author kaique
 */
public class Pessoa implements Serializable{
    
    private String nome;
    private String cpf;
    private int idade;
    private Data dataNascimento;

}
