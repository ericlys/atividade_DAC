
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.crypto.Data;

/**
 *
 * @author ericl
 */
@Entity
public class Aluno extends Pessoa implements Serializable{
    private String matricula;
    @Temporal(TemporalType.DATE)
    private Date dataIngrsso;
    private String turma;

    public Aluno(String matricula, Date dataIngrsso, String turma, int id, String nome, String cpf, int idade, Data dataNascimento, Endereco endereco) {
        super(id, nome, cpf, idade, dataNascimento, endereco);
        this.matricula = matricula;
        this.dataIngrsso = dataIngrsso;
        this.turma = turma;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataIngrsso() {
        return dataIngrsso;
    }

    public void setDataIngrsso(Date dataIngrsso) {
        this.dataIngrsso = dataIngrsso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

   
    
    
}
