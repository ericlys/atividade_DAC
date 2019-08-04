package main;

import dominio.Aluno;
import dominio.AlunoVO;
import dominio.Autor;
import dominio.Livro;
import dominio.Professor;
import dominio.Telefone;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author ericl
 */
public class QueriesCriteria {
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
    private static void todosLivrosAutoresNaoNascidosData(EntityManager entityManager) {
        //String jpql = "SELECT DISTINCT  livro FROM Livro livro, IN (livro.autores) autores WHERE autores.dataNascimento != '1982-11-21'";
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();//manipular um campo em uma clausula. fazer filtro, ordenar, funcoes sql atraves de metodo 
        
        CriteriaQuery<Livro> criteriaQuery = criteriaBuilder.createQuery(Livro.class);//metedos referentes as clausulas do sql. ex: select, from, where, order by..
        Root<Livro> root = criteriaQuery.from(Livro.class);
        Join<Livro, Autor> join = root.join("autores", JoinType.LEFT);
        criteriaQuery.select(root).distinct(true).where(
                criteriaBuilder.notEqual(join.get("dataNascimento"), "1982-11-21")
        );
        TypedQuery<Livro> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(l -> System.out.println(l.getTitulo()));
    }

    //Uma consulta que selecione todos os professores que possuem Telefone e residem na rua “Que atividade fácil”.
    private static void professorTelefoneRuaAtividadeFacil(EntityManager entityManager){
     //   String jpql = "SELECT DISTINCT professor FROM Professor professor LEFT JOIN professor.telefones telefone "
     //   + "WHERE telefone.numero IS NOT NULL AND LOWER(professor.endereco.rua) LIKE '%que atividade fácil%'";
        
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<Professor> criteriaQuery = criteriaBuilder.createQuery(Professor.class);
        Root<Professor> root = criteriaQuery.from(Professor.class);
        
        Join<Professor, Telefone> join = root.join("telefones", JoinType.LEFT);
        
        Predicate telefone = criteriaBuilder.isNotNull(join.get("numero"));
        Predicate rua = criteriaBuilder.like(root.get("endereco").get("rua"), "%que atividade fácil%");     
        criteriaQuery.select(root).distinct(true).where(telefone,rua);   //district é necessário por conta da lista de telefones que cada usuário possui
        
         TypedQuery<Professor> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(p -> System.out.println(p.getNome()));
    }
    
    // Uma classe, AlunoVO, que representa o nome, CPF e idade do Aluno. Crie uma consulta, que retorna uma lista de todos os AlunoVO, selecionando todos os alunos que pertencem a turma de 2019.1.
    private static void createAlunoVOTurma2019_1(EntityManager entityManager){
        //String jpql = "SELECT NEW dominio.AlunoVO(aluno.nome, aluno.cpf, aluno.idade) FROM Aluno aluno WHERE aluno.turma = '2019.1'";
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AlunoVO> criteriaQuery = criteriaBuilder.createQuery(AlunoVO.class);
        Root<Aluno> root = criteriaQuery.from(Aluno.class);
        Predicate turma = criteriaBuilder.like(root.get("turma"),"%2019.1%");
        criteriaQuery.where(turma).select(criteriaBuilder.construct(AlunoVO.class, root.get("nome"), root.get("cpf"), root.get("idade")));
        TypedQuery<AlunoVO> typedQuery =  entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(aVO->System.out.println(aVO.toString()));
    }
    
    //Uma consulta que seleciona todas os Professores que possuem algum telefone que termina em 8.
    private static void professorTelefoneTermino8(EntityManager entityManager){
        //String jpql = "SELECT professor FROM Professor professor LEFT JOIN professor.telefones telefone WHERE telefone.numero LIKE '%8'";
       CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
       CriteriaQuery<Professor> criteriaQuery = criteriaBuilder.createQuery(Professor.class);
       Root<Professor> root = criteriaQuery.from(Professor.class);
       Join<Professor, Telefone> join = root.join("telefones", JoinType.LEFT);
       Predicate numeroFinal = criteriaBuilder.like(join.get("numero"), "%8");
       criteriaQuery.select(root).where(numeroFinal);
       TypedQuery<Professor> typedQuery = entityManager.createQuery(criteriaQuery);
       typedQuery.getResultList().forEach(p->System.out.println(p.getNome()));
    }
    
    //Uma consulta que seleciona todos os livros dos Autores da cidade de Cajazeiras e tiveram seu lançamento entre os dias 01/01/2019 e 12/12/2019.
    private static void livroAutorCajazeirenseLancadoData(EntityManager entityManager){
        //String jpql = "SELECT DISTINCT livro FROM Livro livro, IN (livro.autores) autores WHERE LOWER(autores.endereco.cidade) LIKE '%cajazeiras%' "
        //        + "AND livro.lancamento BETWEEN '2019-01-01' AND '2019-12-12'";
       CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
       CriteriaQuery<Livro> criteriaQuery = criteriaBuilder.createQuery(Livro.class);
       Root<Livro> root = criteriaQuery.from(Livro.class);
       Join<Livro, Autor> join = root.join("autores",JoinType.LEFT);
       Predicate cidade = criteriaBuilder.like(join.get("endereco").get("cidade"), "%Cajazeiras%");
       Predicate lancamento = criteriaBuilder.between(root.get("lancamento"), "2019-01-01", "2019-12-12");
       criteriaQuery.select(root).where(cidade, lancamento).distinct(true);
       TypedQuery<Livro> typedQuery = entityManager.createQuery(criteriaQuery);
       typedQuery.getResultList().forEach(l->System.out.println(l.getTitulo()));
       
    }
    
    // Uma consulta que selecione os Livros dos Autores que começam com a letra “J”.
    private static void livroAutorIniciadoComJ(EntityManager entityManager){
       // String jpql = "SELECT DISTINCT livro FROM Livro livro, IN (livro.autores) autor WHERE LOWER(autor.nome) LIKE 'j%'";
       CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
       CriteriaQuery<Livro> criteriaQuery = criteriaBuilder.createQuery(Livro.class);
       Root<Livro> root = criteriaQuery.from(Livro.class);
       Join<Livro, Autor> join = root.join("autores",JoinType.LEFT);
       Predicate letraInicialNome = criteriaBuilder.like(join.get("nome"), "J%");
       criteriaQuery.select(root).where(letraInicialNome).distinct(true);
       TypedQuery<Livro> typedQuery = entityManager.createQuery(criteriaQuery);
       typedQuery.getResultList().forEach(l->System.out.println("Livro: "+l.getTitulo()));
    }
}
