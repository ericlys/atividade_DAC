/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;

/**
 *
 * @author kaique
 */
public class Telefone implements Serializable{
    
    private String numero;
    private TelefoneType typo;

    public Telefone() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneType getTypo() {
        return typo;
    }

    public void setTypo(TelefoneType typo) {
        this.typo = typo;
    }
    
    
}
