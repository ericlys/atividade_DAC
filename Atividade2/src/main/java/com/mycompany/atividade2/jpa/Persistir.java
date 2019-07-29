package com.mycompany.atividade2.jpa;

import javax.persistence.EntityManager;

public class Persistir {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        em.close();
    }
}
