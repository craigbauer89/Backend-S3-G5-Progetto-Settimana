package services;

import javax.persistence.EntityManager;

import datamodels.CatalogElemento;
import datamodels.Libro;
import datamodels.Period;
import datamodels.Prestito;
import datamodels.Rivista;
import datamodels.Utente;
import persistence.EntityManagerHelper;

public class CatalogElementoDAO {

	public static void inserisciLibro(String codiceISBN, String titolo, int annoPubblicato, int numeroPagine,
			String autore, String genere ) {
		Libro l = new Libro(codiceISBN,  titolo,  annoPubblicato,  numeroPagine,
				 autore,  genere );  
		inserisciLibro(l);
	}
	
	public static void inserisciRivista(int id, String codiceISBN, String titolo, int annoPubblicato, int numeroPagine, Prestito prestito,
			Period period) {
		Rivista p = new Rivista( id,  codiceISBN, titolo,  annoPubblicato,  numeroPagine,
				 period );  
		inserisciRivista(p);
	}

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
	
	public static void cancella(int id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		em.remove(   trova(   id)    );
		em.getTransaction().commit();
		em.close();
	}
	

	public static void modifica(CatalogElemento catologoItem) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		em.merge(catologoItem);
		
		em.getTransaction().commit();
		em.close();
	}
	
	
	
//	ricercaperISBN(String ISBN)
//	ricercaperanno(int anno)
//	ricercaperautore(String autore)
//	ricercapertitolo(String titolo) // o parte di esso
//	ricercaperinprestito(String numerotessera)
//	ricercaprestitiscaduti(String ISBN.scaduti)

}
