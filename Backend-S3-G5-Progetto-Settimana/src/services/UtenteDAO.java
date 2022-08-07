package services;

import javax.persistence.EntityManager;

import datamodels.Utente;
import persistence.EntityManagerHelper;

public class UtenteDAO {


	
	public static void inserisci(int id,String nome, String cognome, int dataNascita, String numeroTessera) {
		Utente u = new Utente( id, nome,  cognome,  dataNascita,  numeroTessera );  
		inserisci(u);
	}

	public static void inserisci(Utente u ) {
		EntityManager em = EntityManagerHelper.getEntityManager();
	
		em.getTransaction().begin();
		em.persist(u);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static Utente trova(int id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Utente u = em.find(  Utente.class  , id)  ;
		em.close();
		return u;
	}
	
	public static void cancella(int id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		em.remove(   trova(   id)    );
		em.getTransaction().commit();
		em.close();
	}
	

	public static void modifica(Utente utente) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		em.merge(utente);
		
		em.getTransaction().commit();
		em.close();
	}


}
