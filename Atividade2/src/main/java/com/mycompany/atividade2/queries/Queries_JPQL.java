package com.mycompany.atividade2.queries;

import com.mycompany.atividade2.jpa.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author ericl
 */
public class Queries_JPQL {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        //pessoaPublicacaoArea3(em);
        //revisorPublicacaoIndustrial(em);
        //revisoresPublicacoesJava(em);
        totalPublicacaoEscritoresPremiados(em);
    }
    
   // O nome da pessoa, o título da publicação e o nome da área em que a pessoa tem o atributo id igual a 3.
    private static void pessoaPublicacaoArea3(EntityManager entityManager){
        String jpql = "SELECT escritor.nome, publicacao.titulo, area.nome FROM Escritor escritor "
                + " JOIN escritor.publicacoes publicacao "
                + " JOIN publicacao.areas area"
                + " WHERE area.cod = '3'"; 
        
      Query query = entityManager.createQuery(jpql);
        List<Object[]> lista = query.getResultList();

        for (Object[] object : lista) {
            System.out.print("Escritor: "+object[0]);
            System.out.print(" Publicacao: "+object[1]);
            System.out.println(" Area: "+object[2]);
        }
    }
   //O título da publicação e o nome do revisor que tenham alguma publicação na área de indústria.  
        private static void revisorPublicacaoIndustrial(EntityManager entityManager){
       String jpql = "SELECT  publicacao.titulo, revisor.nome FROM Revisor revisor"
                + " JOIN revisor.publicacoes publicacao "
                + " JOIN publicacao.areas area"
                + " WHERE LOWER(area.nome) LIKE '%industria%'";
        
      Query query = entityManager.createQuery(jpql);
        List<Object[]> lista = query.getResultList();

       for (Object[] object : lista) {
            System.out.print("Nome: "+object[0]);
            System.out.println(" /Título: "+object[1]);
        }
    }
   // O nome dos Revisores que possuem alguma publicação começando com Java.
    private static void revisoresPublicacoesJava(EntityManager entityManager){
      String jpql = "SELECT revisor.nome FROM Revisor revisor "
              + "JOIN revisor.publicacoes publicacao WHERE UPPER(publicacao.titulo) LIKE 'JAVA%'";
      
      TypedQuery<String> typedQuery = entityManager.createQuery(jpql, String.class);
      typedQuery.getResultList().forEach(System.out::println);
    }
    
    
   // O nome e a quantidade de Publicações escritas por Escritores com mais que três prêmios.
    private static void totalPublicacaoEscritoresPremiados(EntityManager entityManager){
        String jpql = "SELECT escritor.nome, COUNT(publicacao) FROM Escritor escritor, IN (escritor.publicacoes) publicacao "
                + "WHERE escritor.premios > 3 GROUP BY escritor.nome";
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        typedQuery.getResultList().forEach(o->System.out.println("Escritor: "+o[0] +" Quantidade de públicações: "+ o[1]));
    }
    

}

