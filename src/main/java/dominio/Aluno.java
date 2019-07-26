
package dominio;

import java.util.Date;
import javax.xml.crypto.Data;

/**
 *
 * @author ericl
 */
public class Aluno extends Pessoa{
    private String matricula;
    private Date dataIngrsso;
    private String turma;


    public Aluno(String matricula, Date dataIngrsso, String turma, String nome, String cpf, int idade, Data dataNascimento, Endereco endereco) {
        super(nome, cpf, idade, dataNascimento, endereco);
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
