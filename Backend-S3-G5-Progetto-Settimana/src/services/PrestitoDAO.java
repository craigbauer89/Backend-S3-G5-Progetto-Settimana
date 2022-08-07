package services;

import java.time.LocalDate;


import javax.persistence.EntityManager;

import datamodels.Prestito;
import datamodels.Utente;
import persistence.EntityManagerHelper;

public class PrestitoDAO {
	
	
	

	public static void inserisci(Utente utente, LocalDate inizioPrestito, LocalDate restituzionePrestito,
			LocalDate restituzioneEffettiva) {
		Prestito p = new Prestito(utente,  inizioPrestito,  restituzionePrestito,
				 restituzioneEffettiva );  
		inserisci(p);
	}

	public static void inserisci(Prestito p ) {
		EntityManager em = EntityManagerHelper.getEntityManager();
	
		em.getTransaction().begin();
		em.persist(p);
		
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
	

	public static void modifica(Prestito prestito) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		em.merge(prestito);
		
		em.getTransaction().commit();
		em.close();
	}


}
