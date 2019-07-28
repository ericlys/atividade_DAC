/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Embeddable;
/**
 *
 * @author ericl
 */
@Embeddable
public class Endereco implements Serializable{
    private String rua;
    private String bairrro;
    private String cidade;
    private String CEP;

    public Endereco(String rua, String bairrro, String cidade, String CEP) {
        this.rua = rua;
        this.bairrro = bairrro;
        this.cidade = cidade;
        this.CEP = CEP;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairrro() {
        return bairrro;
    }

    public void setBairrro(String bairrro) {
        this.bairrro = bairrro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    @Override
    public String toString() {
        return "Endereco{" + "rua=" + rua + ", bairrro=" + bairrro + ", cidade=" + cidade + ", CEP=" + CEP + '}';
    }  
    
}
