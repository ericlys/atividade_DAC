package com.mycompany.atividade2.jpa;

import com.mycompany.atividade2.domain.Escritor;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import javax.persistence.EntityManager;

public class Persistir {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Escritor[] escritores = {
            new Escritor(
                    1, "Eloá Liz Brito", Date.valueOf(LocalDate.of(1981, Month.DECEMBER, 06))
            ),
            new Escritor(
                    4, "Valentina Jéssica Fernandes", Date.valueOf(LocalDate.of(1968, Month.OCTOBER, 22))
            ),
            new Escritor(
                    1, "Miguel Lorenzo da Rocha", Date.valueOf(LocalDate.of(1989, Month.JULY, 07))
            ),
            new Escritor(
                    3, "Tânia Hadassa Brito", Date.valueOf(LocalDate.of(1967, Month.JULY, 15))
            ),
            new Escritor(
                    1, "Antônia Letícia Almada", Date.valueOf(LocalDate.of(1990, Month.JANUARY, 12))
            )
        };
        
        em.getTransaction().begin();
                for (Escritor e : escritores) {
			em.persist(e);
		}
        em.close();
    }
}
