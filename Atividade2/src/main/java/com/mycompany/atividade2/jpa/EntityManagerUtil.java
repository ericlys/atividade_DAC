package com.mycompany.atividade2.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ericl
 */
public class EntityManagerUtil {
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;
   
    public static EntityManager getEntityManager(){
        if (factory == null){
            factory = Persistence.createEntityManagerFactory("dacjpadb2");
        }
        if(em == null){
            em = factory.createEntityManager();
        }
        return em;      
    }
}
