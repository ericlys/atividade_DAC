package main;

import dominio.Aluno;
import dominio.Autor;
import dominio.Endereco;
import dominio.Livro;
import dominio.Professor;
import dominio.Telefone;
import dominio.TelefoneType;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.EntityManager;

/**
 *
 * @author ericl
 */
public class DadosTabelas {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Aluno[] alunos = {
         new Aluno("2019001", Date.valueOf(LocalDate.of(2019, Month.JANUARY, 12)), "2019.1",
                "Vitória Caroline Lima", 
                "109.581.472-99", 
                24,
                Date.valueOf(LocalDate.of(1995, Month.MAY, 26)),
                new Endereco(
                       "Rua Tucuruçá",
                        "Pacaembu",
                        "Divinópolis",
                        "35504-252"
                )
        ),
        
        
         new Aluno("2019002", Date.valueOf(LocalDate.of(2019, Month.JANUARY, 12)), "2019.1",
                "Filipe Luan Yago Galvão", 
                "585.280.327-87", 
                25,
                Date.valueOf(LocalDate.of(1994, Month.FEBRUARY, 23)),
                new Endereco(
                        "Rua Quirino",
                        "Inácio Barbosa",
                        "Aracaju",
                        "49040-700"
                )
        ),
        
        
         new Aluno("2019003", Date.valueOf(LocalDate.of(2019, Month.JANUARY, 12)), "2019.2",
                "Giovanna Tereza Allana Lopes", 
                "611.512.097-75", 
                30,
                Date.valueOf(LocalDate.of(1989, Month.OCTOBER, 15)),
                new Endereco(
                        "Rua João Pedro Ferraroa",
                        "Itália",
                        "São José dos Pinhais",
                        "83020-430"
                )
        ),
        
       
         new Aluno("2019004", Date.valueOf(LocalDate.of(2019, Month.JANUARY, 12)), "2019.2",
                "Ryan Nathan Luan Ribeiro", 
                "598.146.124-13", 
                30,
                Date.valueOf(LocalDate.of(1989, Month.OCTOBER, 23)),
                new Endereco(
                       "Rua Sérgio Moreira 64",
                        "Centro",
                        "Cachoeira dos Índios",
                        "58935-970"
                )
        ),
        
         new Aluno("2019005", Date.valueOf(LocalDate.of(2019, Month.JANUARY, 12)), "2019.1",
                "Rebeca Alice Ferreira", 
                "117.417.754-34", 
                25,
                Date.valueOf(LocalDate.of(1994, Month.JUNE, 24)),
                new Endereco(
                       "Distrito Várzea Comprida, s/n",
                        "Centro",
                        "Pombal",
                        "58840-971"
                )
        )};
        
        Livro[] livros = {
			new Livro(
                                        " Working effectively with legacy code",
					"9783958459038",
					
					Date.valueOf(LocalDate.of(2004,Month.SEPTEMBER,01)),
					new ArrayList<>()

			),
			new Livro(
                                        "Design Patterns",
					"9780201485370",
					Date.valueOf(LocalDate.of(1994,Month.OCTOBER,21)),
					new ArrayList<>()
			),
			new Livro(
                                        "Clean Code",
					"9780132350884",					
					Date.valueOf(LocalDate.of(2008,Month.AUGUST,07)),
					new ArrayList<>()
			),
			new Livro(                                
					"Java Concurrency in Practice",
					"9780132702256",
					Date.valueOf(LocalDate.of(2006,Month.JANUARY,01)),
					new ArrayList<>()
			),
			new Livro(
					"Domain Driven Design",
					"9780321125217",
					Date.valueOf(LocalDate.of(2003,Month.JANUARY,01)),
					new ArrayList<>()
			),
                        new Livro(
					"Pro JPA 2: Mastering the Java Persistence API",
					"1430219564",
					Date.valueOf(LocalDate.of(2009,Month.OCTOBER,31)),
					new ArrayList<>()
			),
                        new Livro(
					"EJB 3 profissional: java persistence API",
					"8573936967",
					Date.valueOf(LocalDate.of(2008,Month.JANUARY, 01)),
					new ArrayList<>()
			),
                        new Livro(
					"História e vida de Padre Rolin",
					"5393936967",
					Date.valueOf(LocalDate.of(2019,Month.JANUARY, 06)),
					new ArrayList<>()
			),
                        new Livro(
					"Brasileirinhos do sertão",
					"8578235628",
					Date.valueOf(LocalDate.of(2019,Month.OCTOBER, 29)),
					new ArrayList<>()
			)

	};
        
       Autor[] autores  = {
           new Autor(
                "Jéssica Catarina Farias",
                "968.634.771-22",
                58,
                Date.valueOf(LocalDate.of(1961, Month.AUGUST, 05)),
                new Endereco(
                        "Estrada NS 1",
                        "Chácara dos Poderes",
                        "Campo Grande",
                        "79037-801"
                ),
                "instVinc1",
                Arrays.asList(livros[0])
        ),
       
        
         new Autor(
                "Augusto Renato da Costa",
                "216.629.453-70",
                45,
                 Date.valueOf(LocalDate.of(1974, Month.JANUARY, 06)),
                new Endereco(
                        "Rua Cemetron",
                        "São Francisco",
                        "Cajazeiras",
                        "58910-000"
                ),
                "instVinc2",
                Arrays.asList(livros[1])
        ),
         
          new Autor(
                "Kauê Marcos Vinicius Oliver Santos",
                "924.962.471-92",
                36,
                Date.valueOf(LocalDate.of(1983, Month.JANUARY, 18)),
                new Endereco(
                        "Rua H",
                        "Angelim",
                        "Teresina",
                        "64034-428"
                ),
                "instVinc1",
                Arrays.asList(livros[2])
        ),
          
         new Autor(
                "Francisca Louise Stefany Gonçalves",
                "497.404.219-03",
                47,
                Date.valueOf(LocalDate.of(1972, Month.SEPTEMBER, 01)),
                new Endereco(
                        "Rua Jaime Cavalcante de Albuquerque",
                        "Bugi",
                        "Iguatu",
                        "63501-155"
                ),
                "instVinc2",
                Arrays.asList(livros[3])
        ),
           
          new Autor(
                "Levi Miguel Jorge Viana",
                "200.786.179-87",
                34,
                Date.valueOf(LocalDate.of(1985, Month.JANUARY, 06)),
                new Endereco(
                        "Rua Acauã",
                        "Serra Dourada III",
                        "Serra",
                        "29171-417"
                ),
                "instVinc1",
                Arrays.asList(livros[4])
                ),
   
           new Autor(
                "Mike Keith",
                "200.786.179-88",
                36,
                Date.valueOf(LocalDate.of(1982, Month.NOVEMBER, 21)),
                new Endereco(
                        "Rua Acauã",
                        "Serra Dourada III",
                        "Serra",
                        "29171-417"
                ),
                "instVinc1",
                Arrays.asList(livros[5], livros[6])
        ),
           
           new Autor(
                "Merrick Schincariol",
                "200.786.239-88",
                37,
                Date.valueOf(LocalDate.of(1982, Month.JANUARY, 18)),
                new Endereco(
                        "Rua Acauã",
                        "Serra Dourada III",
                        "Serra",
                        "29171-417"
                ),
                "instVinc1",
                Arrays.asList(livros[5])),
                   
               new Autor(
                "Tânia Luna Bruna Gomes",
                "246.002.944-67",
                37,
                Date.valueOf(LocalDate.of(1995, Month.MAY, 26)),
                new Endereco(
                        "Rua do Comércio, s/n",
                        "Centro",
                        "Cajazeiras",
                        "58900-971"
                ),
                "instVinc1",
                Arrays.asList(livros[7])),
                            
             new Autor(
                "Nathan José Nogueira",
                "415.450.875-04",
                28,
                Date.valueOf(LocalDate.of(1991, Month.MARCH, 22)),
                new Endereco(
                        "Rua Coronel Juvêncio Carneiro 489",
                        "Centro",
                        "Cajazeiras ",
                        "58900-970"
                ),
                "instVinc1",
                Arrays.asList(livros[8]))
        };
            
            
             Telefone[][] telefones= {
			{
				new Telefone("(69) 2621-6900", TelefoneType.RESIDENCIAL),
				new Telefone("(69) 98371-1883", TelefoneType.COMERCIAL)
			},
			{
				new Telefone("(71) 3941-0825", TelefoneType.RESIDENCIAL),
				new Telefone("(71) 99887-7237", TelefoneType.COMERCIAL)
			},
			{ 
				new Telefone("(66) 3622-4555", TelefoneType.RESIDENCIAL),
				new Telefone("(66) 99762-8065", TelefoneType.COMERCIAL)
			},
			{ 
				new Telefone("(62) 3548-7467", TelefoneType.RESIDENCIAL),
				new Telefone("(62) 99170-6955", TelefoneType.COMERCIAL)
			},
			{ 
				new Telefone("(27) 2946-0755", TelefoneType.RESIDENCIAL),
				new Telefone("(27) 99756-4908", TelefoneType.COMERCIAL)
                        },
                        { 
				new Telefone("(22) 3861-4448", TelefoneType.RESIDENCIAL),
				new Telefone("(22) 98468-2745", TelefoneType.COMERCIAL)
			}
			
	};
            
            
     
            
            Professor[] professores = {
                 new Professor(
                           Arrays.asList(telefones[0]),
                           3700,
                           "Daniel Marcos Monteiro",
                           "512.872.060-85",
                           34,
                           Date.valueOf(LocalDate.of(1985, Month.MARCH, 05)),
                           new Endereco(
                                   "Rua Catia",
                                   "Jardim Nazaré",
                                   "Nova Iguaçu",
                                   "26065-270"
                           )  
            ),
            
              new Professor(
                           Arrays.asList(telefones[1]),
                           4600,
                           "Anthony Cauê Sales",
                           "748.326.747-06",
                           42,
                           Date.valueOf(LocalDate.of(1977, Month.JANUARY, 22)),
                           new Endereco(
                                   "Sítio Córregos dos Fernandes, s/n",
                                   "Centro",
                                   "Córrego dos Fernandes",
                                   "62807-975"
                           )  
            ),
             
              new Professor(
                           Arrays.asList(telefones[2]),
                           3700,
                           "Sara Sueli Caldeira",
                           "069.749.032-78",
                           28,
                           Date.valueOf(LocalDate.of(1991, Month.MARCH, 03)),
                           new Endereco(
                                   "Rua Turmalina",
                                   "Jóquei Clube",
                                   "Boa Vista",
                                   "69313-078"
                           )  
            ),
             
              new Professor(
                           Arrays.asList(telefones[3]),
                           2800 ,
                           "Sérgio Cláudio Aparício",
                           "791.749.833-69",
                           30,
                           Date.valueOf(LocalDate.of(1989, Month.FEBRUARY, 20)),
                           new Endereco(
                                   "Avenida Pirâmides",
                                   "Mirueira",
                                   "Paulista",
                                   "53405-355"
                           )  
            ),
                    
              new Professor(
                           Arrays.asList(telefones[4]),
                           4600,
                           "Stella Eloá da Cruz",
                           "293.526.829-63",
                           37,
                           Date.valueOf(LocalDate.of(1982, Month.DECEMBER, 27)),
                           new Endereco(
                                   "Rua Constelação",
                                   "São Francisco",
                                   "Porto Velho",
                                   "76813-352"
                           )  
            ),
              new Professor(
                           null,
                           4600,
                           "Cláudia Clara Peixoto",
                           "152.984.935-72",
                           37,
                           Date.valueOf(LocalDate.of(1982, Month.DECEMBER, 9)),
                           new Endereco(
                                   "que atividade fácil",
                                   "São Francisco",
                                   "Porto Velho",
                                   "76813-352"
                           )  
            ),
              new Professor(
                           Arrays.asList(telefones[5]),
                           4600,
                           "Emilly Regina das Neves",
                           "780.636.860-47",
                           40,
                           Date.valueOf(LocalDate.of(1979, Month.NOVEMBER, 23)),
                           new Endereco(
                                   "que atividade fácil",
                                   "São Francisco",
                                   "Porto Velho",
                                   "76813-352"
                           )  
            )};
             
         em.getTransaction().begin();
                for (Autor autor : autores) {
			em.persist(autor);
		}
		for (Aluno aluno : alunos) {
			em.persist(aluno);
		}
		for (Professor professor : professores) {
			em.persist(professor);
		}
                for(Livro l:livros){
			em.persist(l);
		}
         em.getTransaction().commit();
    }
}
