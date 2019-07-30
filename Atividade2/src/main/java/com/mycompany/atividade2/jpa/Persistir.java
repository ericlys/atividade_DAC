package com.mycompany.atividade2.jpa;

import com.mycompany.atividade2.domain.Area;
import com.mycompany.atividade2.domain.Escritor;
import com.mycompany.atividade2.domain.Publicacao;
import com.mycompany.atividade2.domain.Revisor;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;

public class Persistir {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Escritor[] escritores = {
            new Escritor(
                    2, 
                    "Eloá Liz Brito",
                    Date.valueOf(LocalDate.of(1981, Month.DECEMBER, 06))
            ),
            
            new Escritor(
                    6, 
                    "Valentina Jéssica Fernandes", 
                    Date.valueOf(LocalDate.of(1968, Month.OCTOBER, 22))             
            ),
            new Escritor(
                    7, 
                    "Miguel Lorenzo da Rocha",
                    Date.valueOf(LocalDate.of(1989, Month.JULY, 07))
            ),
            new Escritor(
                    5,
                    "Tânia Hadassa Brito",
                    Date.valueOf(LocalDate.of(1967, Month.JULY, 15))
            ),
            new Escritor(
                    2, 
                    "Antônia Letícia Almada", 
                    Date.valueOf(LocalDate.of(1990, Month.JANUARY, 12))
            )
        };
        
        Revisor[] revisores = {
            new Revisor(
                     "Bom",
                    "Mariane Priscila Jéssica da Mota",
                    Date.valueOf(LocalDate.of(1973, Month.MARCH, 14))
            ),
            new Revisor(
                    "Excelente",
                    "Luana Carla Raimunda Caldeira",
                    Date.valueOf(LocalDate.of(1959, Month.APRIL, 19))
            ),
            new Revisor(
                     "Ótimo",
                    "Leandro Benjamin Novaes",
                    Date.valueOf(LocalDate.of(1967, Month.NOVEMBER, 9))
            ),
            new Revisor(
                     "Bom",
                    "Sarah Bárbara Castro",
                    Date.valueOf(LocalDate.of(1954, Month.MAY, 24))
            )
        };
        
        Area[] areas = {
            new Area(
                  "Ti"
            ),
            new Area(
                    "Tecnologia"
            ),
            new Area(
                    "Design"
            )
    };
        
        Publicacao[] publicacoes = {
            new Publicacao(
                    "Sistemas Operacionais - O que é Deadlock?", 
                    escritores[0], 
                    Arrays.asList(areas[0],areas[1])
            ),
            new Publicacao(
                    "O que é um SGBD?",
                   escritores[1], 
                    Arrays.asList(areas[0],areas[2])
            ),
            new Publicacao(
                    "Conhecendo o Arduino Uno - Aula 10 – Acionando um carga com o uso de relê (parte 1)", 
                    escritores[2], 
                    Arrays.asList(areas[1],areas[2])
            ),
            new Publicacao(
                    "Programação Orientada a Objetos", 
                    escritores[3], 
                    Arrays.asList(areas[2])
            ),
            new Publicacao(
                    "Primeiros passos com o Angular Material", 
                    escritores[4], 
                    Arrays.asList(areas[2])
            )
        };
        
        em.getTransaction().begin();
                for (Escritor e : escritores) {
			em.persist(e);
		}
                for(Area a:areas){
                      em.persist(a);
                 }
                 for (Publicacao p : publicacoes) {
			em.persist(p);
		}
                 for(Revisor r:revisores){
                     em.persist(r);
                 }   
                 revisores[0].setPublicacoes(Arrays.asList(publicacoes[0]));
                 revisores[1].setPublicacoes(Arrays.asList(publicacoes[1]));
                 revisores[2].setPublicacoes(Arrays.asList(publicacoes[2]));
                 revisores[3].setPublicacoes(Arrays.asList(publicacoes[3]));
                 revisores[3].setPublicacoes(Arrays.asList(publicacoes[4]));
        em.getTransaction().commit();
        em.close();
    }
}
