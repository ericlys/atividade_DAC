package main;

import dominio.AlunoVO;
import dominio.Livro;
import dominio.Professor;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author ericl
 */
public class Queries_JPQL {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        //todosLivrosAutoresNaoNascidosData(em);
        //professorTelefoneRuaAtividadeFacil(em);
        //createAlunoVOTurma2019_1(em);
        //professorTelefoneTermino8(em);
        //livroAutorCajazeirenseLancadoData(em);
        livroAutorIniciadoComJ(em);
    }

    //Uma consulta que selecione todos os livros dos autores que não nasceram no dia 21/11/1982.
    private static void todosLivrosAutoresNaoNascidosData(EntityManager em) {
        String jpql = "SELECT DISTINCT  livro FROM Livro livro, IN (livro.autores) autores WHERE autores.dataNascimento != '1982-11-21'";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.getResultList().forEach(l -> System.out.println(l.getTitulo()));
    }

    //Uma consulta que selecione todos os professores que possuem Telefone e residem na rua “Que atividade fácil”.
    private static void professorTelefoneRuaAtividadeFacil(EntityManager em){
        String jpql = "SELECT professor FROM Professor professor LEFT JOIN (professor.Telefone) telefone "
                + "WHERE telefone IS NOT NULL AND LOWER(professor.endereco.rua) LIKE '%que atividade fácil%'";
        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.getResultList().forEach(p -> System.out.println(p.getNome()));
    }
    
    // Uma classe, AlunoVO, que representa o nome, CPF e idade do Aluno. Crie uma consulta, que retorna uma lista de todos os AlunoVO, selecionando todos os alunos que pertencem a turma de 2019.1.
    private static void createAlunoVOTurma2019_1(EntityManager em){
        String jpql = "SELECT NEW dominio.AlunoVO(aluno.nome, aluno.cpf, aluno.idade) FROM Aluno aluno WHERE aluno.turma = '2019.1'";
        TypedQuery<AlunoVO> query = em.createQuery(jpql, AlunoVO.class);
        query.getResultList().forEach(aVO->System.out.println(aVO.toString()));
    }
    
    //Uma consulta que seleciona todas os Professores que possuem algum telefone que termina em 8.
    private static void professorTelefoneTermino8(EntityManager em){
        String jpql = "SELECT professor FROM Professor professor LEFT JOIN professor.telefones telefone WHERE telefone.numero LIKE '%8'";
        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.getResultList().forEach(p->System.out.println(p.getNome()));
    }
    
    //Uma consulta que seleciona todos os livros dos Autores da cidade de Cajazeiras e tiveram seu lançamento entre os dias 01/01/2019 e 12/12/2019.
    private static void livroAutorCajazeirenseLancadoData(EntityManager em){
        String jpql = "SELECT DISTINCT livro FROM Livro livro, IN (livro.autores) autores WHERE LOWER(autores.endereco.cidade) LIKE '%cajazeiras%' "
                + "AND livro.lancamento BETWEEN '2019-01-01' AND '2019-12-12'";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.getResultList().forEach(l -> System.out.println("Livro: "+l.getTitulo()));
    }
    
    // Uma consulta que selecione os Livros dos Autores que começam com a letra “J”.
    private static void livroAutorIniciadoComJ(EntityManager em){
        String jpql = "SELECT DISTINCT livro FROM Livro livro, IN (livro.autores) autor WHERE LOWER(autor.nome) LIKE 'j%'";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.getResultList().forEach(l->System.out.println("Livro: "+l.getTitulo()));
    }
}
