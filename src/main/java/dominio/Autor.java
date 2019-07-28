/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author kaique
 */
@Entity
public class Autor extends Pessoa implements Serializable{
     private String instituicaoVinculada ;
     
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "autor_livro",
        joinColumns = @JoinColumn(name = "livro_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id"))
    private List<Livro> livros;

    public Autor(String nome, String cpf, int idade, Date dataNascimento, Endereco endereco, String instituicaoVinculada, List<Livro> livros) {
        super(nome, cpf, idade, dataNascimento, endereco);
        this.instituicaoVinculada = instituicaoVinculada;
        this.livros = livros;
    }

    public Autor() {
    }
   
   public String getInstituicaoVinculada() {
        return instituicaoVinculada;
    }

    public void setInstituicaoVinculada(String instituicaoVinculada) {
        this.instituicaoVinculada = instituicaoVinculada;
    }
    
    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Autor{" + "instituicaoVinculada=" + instituicaoVinculada + ", livros=" + livros + '}';
    }

}
