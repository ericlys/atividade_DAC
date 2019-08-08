package com.mycompany.atividade2.queries;

import com.mycompany.atividade2.domain.Area;
import com.mycompany.atividade2.domain.Escritor;
import com.mycompany.atividade2.domain.Publicacao;
import com.mycompany.atividade2.domain.Revisor;
import com.mycompany.atividade2.jpa.EntityManagerUtil;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import jdk.nashorn.internal.objects.annotations.Where;

/**
 *
 * @author ericl
 */
public class Queries_Criteria {
    public static void main(String[] args) {
         EntityManager em = EntityManagerUtil.getEntityManager();
         
        //pessoaPublicacaoArea3(em);
        //revisorPublicacaoIndustrial(em);
        //revisoresPublicacoesJava(em);
        totalPublicacaoEscritoresPremiados(em);
    }
    
    // O nome da pessoa, o título da publicação e o nome da área em que a pessoa tem o atributo id igual a 3.
    private static void pessoaPublicacaoArea3(EntityManager entityManager){
         CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
         Root<Escritor> root = criteriaQuery.from(Escritor.class);
        
         Join<Escritor, Publicacao> joinEP = root.join("publicacoes",JoinType.LEFT);
         Join<Publicacao, Area> joinPA = joinEP.join("areas",JoinType.LEFT);
         
         Predicate id = criteriaBuilder.equal(joinPA.get("cod"), 3);
         
         criteriaQuery.multiselect(
                root.get("nome"), joinEP.get("titulo"),  joinPA.get("nome")
         ).where(id);
         
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(
                e-> System.out.println("Nome: "+e[0]+" título: "+e[1]+ " área: " +e[2]+".")
        );
    }
   //O título da publicação e o nome do revisor que tenham alguma publicação na área de indústria.  
        private static void revisorPublicacaoIndustrial(EntityManager entityManager){
   
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Revisor> root = criteriaQuery.from(Revisor.class);
        
        Join<Revisor, Publicacao> joinRP = root.join("publicacoes");
        Join<Publicacao, Area> joinPA = joinRP.join("areas");
        
        Predicate areaNome = criteriaBuilder.like(joinPA.get("nome"), "Industria");
        
        criteriaQuery.multiselect(
                joinRP.get("titulo"), root.get("nome")
        ).where(areaNome);
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(
            r -> System.out.println("Publicacao: "+r[0]+ " Revisor: "+r[1])
        );
    }
   // O nome dos Revisores que possuem alguma publicação começando com Java.
    private static void revisoresPublicacoesJava(EntityManager entityManager){
     
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Revisor> criteriaQuery = criteriaBuilder.createQuery(Revisor.class);
        Root<Revisor> root = criteriaQuery.from(Revisor.class);
        
        Join<Revisor,Publicacao> joinRP = root.join("publicacoes");
        
        Predicate inicioJava = criteriaBuilder.like(joinRP.get("titulo"), "java%");
        
        criteriaQuery.select(root).where(inicioJava);
        
        TypedQuery<Revisor> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(
            r -> System.out.println(r.getNome())
        );
    }
    
    
   // O nome e a quantidade de Publicações escritas por Escritores com mais que três prêmios.
    private static void totalPublicacaoEscritoresPremiados(EntityManager entityManager){
         // String jpql = "SELECT escritor.nome, COUNT(publicacao) FROM Escritor escritor, IN (escritor.publicacoes) publicacao "
          //      + "WHERE escritor.premios > 3 GROUP BY escritor.nome";
          
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Escritor> root = criteriaQuery.from(Escritor.class);
        
        Join<Escritor, Publicacao> joinEP = root.join("publicacoes", JoinType.LEFT);
        
        Predicate maisqueTres = criteriaBuilder.gt(root.get("premios"), 3); //Testa se a primeira expressão numérica é maior que a segunda expressão numérica 
        
        criteriaQuery.multiselect(root.get("nome"), criteriaBuilder.count(joinEP)).where(maisqueTres).groupBy(root.get("nome"));
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(
                e-> System.out.println("Escritor: "+e[0]+" quantidade de publicacoes: "+e[1])
        );
    }
}
