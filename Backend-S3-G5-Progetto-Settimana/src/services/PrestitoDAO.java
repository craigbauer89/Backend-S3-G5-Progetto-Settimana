package services;

import java.util.Date;

import javax.persistence.EntityManager;

import datamodels.Prestito;
import datamodels.Utente;
import persistence.EntityManagerHelper;

public class PrestitoDAO {
	
	
	

	public static void inserisci(int id, Utente utente, Date inizioPrestito, Date restituzionePrestito,
			Date restituzioneEffettiva) {
		Prestito p = new Prestito(id,  utente,  inizioPrestito,  restituzionePrestito,
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
