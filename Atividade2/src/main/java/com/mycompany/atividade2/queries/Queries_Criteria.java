package com.mycompany.atividade2.queries;

import com.mycompany.atividade2.domain.Area;
import com.mycompany.atividade2.domain.Escritor;
import com.mycompany.atividade2.domain.Publicacao;
import com.mycompany.atividade2.jpa.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
public class Queries_Criteria {
    public static void main(String[] args) {
         EntityManager em = EntityManagerUtil.getEntityManager();
         
        pessoaPublicacaoArea3(em);
        //revisorPublicacaoIndustrial(em);
        //revisoresPublicacoesJava(em);
        //totalPublicacaoEscritoresPremiados(em);
    }
    
    // O nome da pessoa, o título da publicação e o nome da área em que a pessoa tem o atributo id igual a 3.
    private static void pessoaPublicacaoArea3(EntityManager entityManager){
    //    String jpql = "SELECT escritor.nome, publicacao.titulo, area.nome FROM Escritor escritor "
     //           + " JOIN escritor.publicacoes publicacao "
      //          + " JOIN publicacao.areas area"
       //         + " WHERE area.cod = '3'"; 
        
         CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
         CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery(Object.class);
         Root<Escritor> root = criteriaQuery.from(Escritor.class);
        
         Join<Escritor, Publicacao> joinEP = root.join("publicacoes",JoinType.LEFT);
         Join<Publicacao, Area> joinPA = root.join("areas",JoinType.LEFT);
         
         Predicate id = criteriaBuilder.equal(root.get("Id"), 3);
         criteriaQuery.multiselect(
                root.get("nome"), joinEP.get("titulo"),  joinPA.get("nome"));
          
      entityManager.createQuery(criteriaQuery).getResultList()
            .forEach(
                g -> System.out.println(
                      
                );
            
    }
   //O título da publicação e o nome do revisor que tenham alguma publicação na área de indústria.  
        private static void revisorPublicacaoIndustrial(EntityManager entityManager){
  
    }
   // O nome dos Revisores que possuem alguma publicação começando com Java.
    private static void revisoresPublicacoesJava(EntityManager entityManager){
      
    }
    
    
   // O nome e a quantidade de Publicações escritas por Escritores com mais que três prêmios.
    private static void totalPublicacaoEscritoresPremiados(EntityManager entityManager){
    
    }
}
