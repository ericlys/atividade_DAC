package main;

import dominio.Aluno;
import dominio.Autor;
import dominio.Endereco;
import dominio.Professor;
import dominio.Telefone;
import dominio.TelefoneType;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ericl
 */
public class DadosTabelas {
    public static void main(String[] args) {
        EntityManager em = Persistence
            .createEntityManagerFactory("AtividadeJPA")
            .createEntityManager();
        
        
        Aluno[] alunos = {
         new Aluno("2019001", Date.valueOf(LocalDate.of(2019, Month.JANUARY, 12)), "ADS",
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
        
        
         new Aluno("2019002", Date.valueOf(LocalDate.of(2019, Month.JANUARY, 12)), "ADS",
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
        
        
         new Aluno("2019003", Date.valueOf(LocalDate.of(2019, Month.JANUARY, 12)), "ADS",
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
        
       
         new Aluno("2019004", Date.valueOf(LocalDate.of(2019, Month.JANUARY, 12)), "ADS",
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
        
         new Aluno("2019005", Date.valueOf(LocalDate.of(2019, Month.JANUARY, 12)), "ADS",
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
        
       Autor[] autores  = {
           new Autor(
                "Giovanna Aurora Rocha",
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
                new ArrayList<>()
        ),
       
        
         new Autor(
                "Augusto Renato da Costa",
                "216.629.453-70",
                45,
                 Date.valueOf(LocalDate.of(1974, Month.JANUARY, 06)),
                new Endereco(
                        "Rua Cemetron",
                        "São Francisco",
                        "Porto Velho",
                        "76813-242"
                ),
                "instVinc2",
                new ArrayList<>()
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
                new ArrayList<>()
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
                new ArrayList<>()
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
                new ArrayList<>()
        )};
            
            
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
				new Telefone("(27) 99756-4909", TelefoneType.COMERCIAL)
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
         em.getTransaction().commit();
    }
}
