/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author kaique
 */
@Embeddable
public class Telefone implements Serializable{
    
    @Id
    @GeneratedValue 
    private int Id;
    private String numero;
    @Enumerated(EnumType.ORDINAL)
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

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
}
