package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import datamodels.CatalogElemento;
import datamodels.Libro;
import datamodels.Prestito;
import datamodels.Rivista;
import datamodels.Utente;
import persistence.EntityManagerHelper;

public class CatalogElementoDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CatalogElementoDAO.class);

	public static void inserisciLibro(String codiceISBN, String titolo, int annoPubblicato, int numeroPagine, Prestito prestito,
			String autore, String genere ) {
		Libro l = new Libro(codiceISBN,  titolo,  annoPubblicato,  numeroPagine,prestito,
				 autore,  genere );  
		inserisciLibro(l);
	}
	
//	public static void inserisciRivista(int id, String codiceISBN, String titolo, int annoPubblicato, int numeroPagine, Prestito prestito,
//			Period period) {
//		Rivista p = new Rivista( id,  codiceISBN, titolo,  annoPubblicato,  numeroPagine,prestito,
//				 period );  
//		inserisciRivista(p);
//	}

	public static void inserisciLibro(Libro l ) {
		EntityManager em = EntityManagerHelper.getEntityManager();
	
		em.getTransaction().begin();
		em.persist(l);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void inserisciRivista(Rivista r ) {
		EntityManager em = EntityManagerHelper.getEntityManager();
	
		em.getTransaction().begin();
		em.persist(r);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static Utente trova(int id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Utente u = em.find(  Utente.class  , id)  ;
		em.close();
		return u;
	}
	
	public static Utente trovaISBN(String codiceISBN) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Utente u = em.find(  Utente.class  , codiceISBN)  ;
		em.close();
		return u;
	}
	
//	public static void cancella(int id) {
//		EntityManager em = EntityManagerHelper.getEntityManager();
//		em.getTransaction().begin();
//		em.remove(   trova(   id)    );
//		em.getTransaction().commit();
//		em.close();
//	}
	
	public static void delete(int id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		CatalogElemento item = em.find( CatalogElemento.class, id);
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		em.remove(item);
		trans.commit();
		em.close();
		
	}
	
	public static void deleteByISBN(String codiceISBN) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		CatalogElemento item = em.find( CatalogElemento.class, codiceISBN);
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		em.remove(item);
		trans.commit();
		em.close();
		
	}
	
	
//	public static void rimouverePerISBN(String codiceISBN) {
//		EntityManager em = EntityManagerHelper.getEntityManager();
//		em.getTransaction().begin();
//		em.remove(   trovaISBN(   codiceISBN)    );
//		em.getTransaction().commit();
//		em.close();
//	}
	

	public static void modifica(CatalogElemento catologoItem) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		em.merge(catologoItem);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<CatalogElemento> ricercaPerISBN(String codiceISBN) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			log.debug("ricercaPerISBN({})", codiceISBN);
			var query = em.createNamedQuery("CatalogElemento.SELECT_ELEMENTO_BY_ISBN", CatalogElemento.class);
			query.setParameter("sigla", codiceISBN);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving cities by province acronym", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}
	
	
	public static List<CatalogElemento> ricercaPerAnno(int anno) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			log.debug("ricercaPerAnno({})", anno);
			var query = em.createNamedQuery("CatalogElemento.SELECT_ELEMENTO_BY_ANNO", CatalogElemento.class);
			query.setParameter("anno", anno);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving cities by province acronym", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}
	
	public static List<Libro> ricercaPerAutore(String autore) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			log.debug("ricercaPerAutore({})", autore);
			var query = em.createNamedQuery("Libro.SELECT_ELEMENTO_BY_AUTORE", Libro.class);
			query.setParameter("autore", autore);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving cities by province acronym", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
		
	}
	
		public static List<CatalogElemento> ricercaPerTitolo(String titolo) {
			EntityManager em = EntityManagerHelper.getEntityManager();
			try {
				log.debug("ricercaPerTitolo({})", titolo);
				var query = em.createNamedQuery("CatalogElemento.SELECT_ELEMENTO_BY_TITOLO", CatalogElemento.class);
				query.setParameter("titolo", titolo);
				return query.getResultList();
			} catch (Exception e) {
				log.error("Error retrieving cities by province acronym", e);
				return new ArrayList<>();
			} finally {
				em.close();
			}
		}
	
	
	
	

	
	public static List<CatalogElemento> getItems() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			TypedQuery<CatalogElemento> query = em.createNamedQuery("CatalogElemento.SELECT_ALL_QUERY", CatalogElemento.class);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving areas", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}
	
//	ricercaperISBN(String ISBN)
//	ricercaperanno(int anno)
//	ricercaperautore(String autore)
//	ricercapertitolo(String titolo) // o parte di esso
//	ricercaperinprestito(String numerotessera)
//	ricercaprestitiscaduti(String ISBN.scaduti)

}
