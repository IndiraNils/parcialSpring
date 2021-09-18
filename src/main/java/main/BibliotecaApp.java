package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Autor;
import entities.Domicilio;
import entities.Libro;
import entities.Localidad;
import entities.Persona;


public class BibliotecaApp {

	public static void main(String[] args) {

		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em=emf.createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			Persona persona= Persona.builder().nombre("Luciana").apellido("Rosati").dni(38524861).build();
			
			Persona persona2= Persona.builder().nombre("Leandro").apellido("Quiroga").dni(40582455).build();
			
			Domicilio domicilio= Domicilio.builder().calle("San Martín").numero(5246).build();
			
			Domicilio domicilio2= Domicilio.builder().calle("San Martín").numero(5248).build();
			
			Localidad localidad= Localidad.builder().denominacion("Coquimbito").build();
			
			Libro libro= Libro.builder().titulo("1984").fecha(1949).genero("Novela").paginas(430).build();
			
			Autor autor= Autor.builder().nombre("George").apellido("Orwell").biografia("dewidj").build();
	
			Autor autor2= Autor.builder().nombre("fewaf").apellido("Orwefewafll").biografia("dewiffewfdj").build();
			
			libro.getAutores().add(autor);
			libro.getAutores().add(autor2);
			
			persona.setDomicilio(domicilio);
			persona2.setDomicilio(domicilio2);
			domicilio.setLocalidad(localidad);
			domicilio2.setLocalidad(localidad);
			persona.getLibros().add(libro);
			
			em.persist(autor);
			em.persist(autor2);
			em.persist(persona);
			em.persist(persona2);
			
			em.flush();
			
			
			em.getTransaction().commit();
			
		}catch(Exception e){
			
			em.getTransaction().rollback();
			
		}
			
			//cerramos la conexion 
			em.close();
			emf.close();
			
		}
}
	
			