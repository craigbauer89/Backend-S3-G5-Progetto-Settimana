package program;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import datamodels.Libro;
import datamodels.Period;
import datamodels.Prestito;
import datamodels.CatalogElemento;
import datamodels.Rivista;
import datamodels.Utente;

import services.CatalogElementoDAO;
import services.PrestitoDAO;
import services.UtenteDAO;

public class BiblioCatalogoProgram {
	
	private static final Logger log = LoggerFactory.getLogger(BiblioCatalogoProgram.class);
	
public static void main(String[] args) {
		
	
		
//		Libro item1 = new Libro("122", "Amazing Places", 1996, 430, "Tim Lovejoy", "Action");
//		Rivista item2 = new Rivista("522", "A Magazine",  2021, 29, Period.MENSILE);
//		CatalogElementoDAO.inserisciLibro(item1);
//		CatalogElementoDAO.inserisciRivista(item2);
	
	//Aggiunte di un Utente
			List<Utente> utenti = new ArrayList<>();

			utenti.add(new Utente("Jimmy", "Fallon", 1996, "BR209373"));
			utenti.add(new Utente("Burt", "Lancaster", 1946, "BR827267"));
			utenti.add(new Utente("Owen", "Hughes", 2002, "BR635378"));
			utenti.add(new Utente("Tim", "Murphy", 1995, "BR928267"));
			utenti.add(new Utente("Billy", "Burns",2010, "BR209373"));
			utenti.add(new Utente("Archie", "Robinson", 1986, "BR145278"));
			utenti.add(new Utente("Bonny", "Laporte", 2000, "BR453627"));
		
			
			for (int i = 0; i < utenti.size(); i ++) {
			UtenteDAO.inserisci((Utente)utenti.get(i));
				
			}
	
	
	//Aggiunte di un Prestito
	List<Prestito> prestiti = new ArrayList<>();

	prestiti.add(new Prestito(utenti.get(1), LocalDate.of(2022, 01, 26) , LocalDate.of(2022, 02, 26), LocalDate.of(2022, 02, 24) ));
	prestiti.add(new Prestito(utenti.get(2), LocalDate.of(2021, 01, 11) , LocalDate.of(2021, 02, 10) , LocalDate.of(2021, 05, 10) ));
	prestiti.add(new Prestito(utenti.get(3), LocalDate.of(2022, 06, 17) , LocalDate.of(2022, 07, 17) , LocalDate.of(2022, 07, 17) ));
	prestiti.add(new Prestito(utenti.get(4), LocalDate.of(2022, 03, 04) , LocalDate.of(2022, 04, 03) , LocalDate.of(2022, 07, 04) ));
	prestiti.add(new Prestito(utenti.get(5), LocalDate.of(2022, 06, 24) , LocalDate.of(2022, 07, 24) , LocalDate.of(2022, 07, 22) ));
	
	
	for (int i = 0; i < prestiti.size(); i ++) {
	PrestitoDAO.inserisci((Prestito)prestiti.get(i));
		
	}
	
	
		//1. Aggiunta di un elemento del catalogo
		List<CatalogElemento> elementi = new ArrayList<>();
		
		
		elementi.add(new Libro("122", "Amazing Places", 1996, 430, prestiti.get(1), "Tim Lovejoy", "Action"));
		elementi.add(new Libro("123", "Arturo La Grande", 2005, 859,prestiti.get(2), "Marco Mauri", "Drama"));
		elementi.add(new Libro("124", "La Grande Bellezza", 2022, 789, prestiti.get(3),"Marco Rossi", "Crimi"));
		elementi.add(new Libro("125", "Dancing in the Sun", 2022, 510,prestiti.get(4), "Marco Bruno", "Love"));
		elementi.add(new Libro("126", "A Wonderful life", 2007, 560, prestiti.get(0),"Marco Bruno", "Love"));
		elementi.add(new Libro("127", "Chi sapremmo", 2022, 560, prestiti.get(1),"Marco Bruno", "Crimi"));
		elementi.add(new Libro("128", "La Bella Vita", 2008, 200,prestiti.get(2), "Jane Verdi", "Drama"));
		elementi.add(new Rivista("222", "Mens Health",  2022, 15,prestiti.get(3), Period.MENSILE));
		elementi.add(new Rivista("322", "Hello",  2022, 22, prestiti.get(4), Period.MENSILE));
		elementi.add(new Rivista("422", "Vogue",  2021, 29, prestiti.get(0), Period.MENSILE));
		elementi.add(new Rivista("522", "A Magazine",  2021, 29, prestiti.get(1), Period.MENSILE));
		
		for (int i = 0; i < elementi.size(); i ++) {
			
			if (elementi.get(i) instanceof Libro) {
		CatalogElementoDAO.inserisciLibro((Libro)elementi.get(i));
			}
			else if (elementi.get(i) instanceof Rivista){
				CatalogElementoDAO.inserisciRivista((Rivista)elementi.get(i));
			}
			
		}
		
//		2. Rimozione di un elemento del catalogo dato un codice ISBN
		CatalogElementoDAO.deleteByISBN("422");


		
//		3. Ricerca per ISBN
		log.info("Il elemento dato un ISBN particolare");
		var l = CatalogElementoDAO.ricercaPerISBN("122");
		log.info("Il elementi sono {}", l.size());
		l.stream().forEach(c -> log.info("Il elemento di ISBN 122: {}", c));

		
//		4. Ricerca per anno pubblicazione
//		log.info("Elenco degli 	elementi di un anno particolare");
		
//		5. Ricerca per autore
//		log.info("Elenco degli 	elementi di un autore particolare");
		
	
//		6. Ricerca per titolo o parte di esso
//		log.info("Elenco degli 	elementi simile ad un titolo particolare");
		
//		7. Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
//		log.info("Elenco degli 	elementi attualmente in prestito dato un numero di tessera utente");
		
		
//		8. Ricerca di tutti i prestiti scaduti e non ancora restituiti
//		log.info("Elenco dei prestiti scaduti e non ancora restituiti");
		
		
//		service.getAreas().forEach(a -> log.info("{}", a));
//		log.info("Città in archivio: {} ", service.getCities().size());
//		log.info("Recupero di città per provincia");
//		var l = service.getCitiesByProvinceAcronym("BA");
//		log.info("Citta in provincia di Bari (BA): {}", l.size());
//		l.stream().forEach(c -> log.info("{}", c));
//		log.info("Città in provincia di Bari con il nome che inizia per A: {}", // 
//				service.getCitiesByProvinceAcronymAndNameContains("A%", "BA"));
//		
//		for(int i = 0; i < 3; ++i)
//			log.info("Pagina n. {} delle province: {}", i, service.getProvincesByPages(i, 50));
		
		
		
}
}
