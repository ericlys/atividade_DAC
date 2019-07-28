/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;


import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.crypto.Data;

/**
 *
 * @author kaique
 */
@Entity
public class Autor extends Pessoa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     private String instituicaoVinculada ;
     
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "autor_livro",
        joinColumns = @JoinColumn(name = "livro_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id"))
    private List<Livro> livros;

    public Autor(int id, String nome, String cpf, int idade, Data dataNascimento, Endereco endereco, String instituicaoVinculada, List<Livro> livros) {
        super(id, nome, cpf, idade, dataNascimento, endereco);
        this.instituicaoVinculada = instituicaoVinculada;
        this.livros = livros;
    }

   public String getInstituicaoVinculada() {
        return instituicaoVinculada;
    }

    public void setInstituicaoVinculada(String instituicaoVinculada) {
        this.instituicaoVinculada = instituicaoVinculada;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", instituicaoVinculada=" + instituicaoVinculada + ", livros=" + livros + '}';
    }
    
    
   
}
