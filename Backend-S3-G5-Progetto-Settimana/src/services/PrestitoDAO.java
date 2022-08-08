package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import datamodels.Prestito;
import datamodels.Utente;
import persistence.EntityManagerHelper;

public class PrestitoDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CatalogElementoDAO.class);
	

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
	
//	public static List<Prestito> ricercaPrestitoScaduti(LocalDate thirtydaysfromtoday) {
//	EntityManager em = EntityManagerHelper.getEntityManager();
//	try {
//		log.debug("ricercaPrestitoPerTessera({})", thirtydaysfromtoday);
//		var query = em.createNamedQuery("Prestito.SELECT_ELEMENTO_BY_TESSERA", Prestito.class);
//		query.setParameter("thirtydaysfromtoday", thirtydaysfromtoday);
//		return query.getResultList();
//	} catch (Exception e) {
//		log.error("Error retrieving cities by province acronym", e);
//		return new ArrayList<>();
//	} finally {
//		em.close();
//	}
//}
	
//	public static List<Prestito> ricercaPrestitoPerTessera(LocalDate today) {
//		EntityManager em = EntityManagerHelper.getEntityManager();
//		try {
//			log.debug("ricercaPrestitoPerTessera({})", today);
//			var query = em.createNamedQuery("Prestito.SELECT_ELEMENTO_BY_TESSERA", Prestito.class);
//			query.setParameter("today", today);
//			return query.getResultList();
//		} catch (Exception e) {
//			log.error("Error retrieving cities by province acronym", e);
//			return new ArrayList<>();
//		} finally {
//			em.close();
//		}
//	}


}
