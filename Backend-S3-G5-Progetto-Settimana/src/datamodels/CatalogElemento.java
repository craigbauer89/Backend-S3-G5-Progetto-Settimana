package datamodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


	@Entity
	@Inheritance(strategy = InheritanceType.JOINED)
	@Table(name = "catologoItems")

		public abstract class CatalogElemento { //implements  {
			
			private int id;
			private String codiceISBN;
			private String titolo;
			private int annoPubblicato;
			private int numeroPagine;
			private Prestito prestito;
			
			public CatalogElemento(int id, String codiceISBN, String titolo, int annoPubblicato, int numeroPagine) {
				this.id = id;
				this.codiceISBN = codiceISBN;
				this.titolo = titolo;
				this.annoPubblicato = annoPubblicato;
				this.numeroPagine = numeroPagine;
				
			}
			
			public CatalogElemento(String codiceISBN, String titolo, int annoPubblicato, int numeroPagine) {
				this.codiceISBN = codiceISBN;
				this.titolo = titolo;
				this.annoPubblicato = annoPubblicato;
				this.numeroPagine = numeroPagine;
				
			}
			
			public CatalogElemento() {

			}
			
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getCodiceISBN() {
				return codiceISBN;
			}

			public void setCodiceISBN(String codiceISBN) {
				this.codiceISBN = codiceISBN;
			}

			public String getTitolo() {
				return titolo;
			}

			public void setTitolo(String titolo) {
				this.titolo = titolo;
			}

			public int getAnnoPubblicato() {
				return annoPubblicato;
			}

			public void setAnnoPubblicato(int annoPubblicato) {
				this.annoPubblicato = annoPubblicato;
			}

			public int getNumeroPagine() {
				return numeroPagine;
			}

			public void setNumeroPagine(int numeroPagine) {
				this.numeroPagine = numeroPagine;
			}

			@ManyToOne 
			public Prestito getPrestito() {
				return prestito;
			}

			public void setPrestito(Prestito prestito) {
				this.prestito = prestito;
			}

			@Override
			public String toString() {
				return String.format(
						"CatologoItem [id=%s, codiceISBN=%s, titolo=%s, annoPubblicato=%s, numeroPagine=%s, prestito=%s]",
						id, codiceISBN, titolo, annoPubblicato, numeroPagine, prestito);
			}

		
			
		
	//
//			 @Override
//			public String toCsv() {
//				// csv comune a tutti gli elementi:
//				// isbn;titolo;anno di pubblicazione;pagine
//				return String.format("%s;%s;%d;%d", isbn, title, publishedYear, pages);
//			}

//			/**
//			 * Recupera la parte di propria competenza dal csv.
//			 * 
//			 * @param csv     il csv da leggere.
//			 * @param startAt il campo da cui partire nella lettura.
//			 * @return il campo a cui è arrivata la lettura.
//			 */
//			protected int fromCsv(String csv, int startAt) {
//				String[] parts = csv.split(";");
//				isbn = parts[startAt];
//				title = parts[startAt + 1];
//				publishedYear = Integer.parseInt(parts[startAt + 2]);
//				pages = Integer.parseInt(parts[startAt + 3]);
//				return 4 + startAt;
//			}
	//
//			@Override
//			public int fromCsv(String csv) {
//				return fromCsv(csv, 0);
//			}
	//
//			/**
//			 * Uguaglianza tra oggetti della stessa classe e con medesimo
//			 * {@code hashCode()}.
//			 */
//			@Override
//			public boolean equals(Object obj) {
//				return obj != null && obj.getClass().equals(getClass()) && obj.hashCode() == hashCode();
//			}
	//
//			/**
//			 * Hash code basato sul campo {@code isbn}.
//			 */
//			@Override
//			public int hashCode() {
//				return Objects.hash(isbn);
//			}
	//
//			/**
//			 * Ordinamento di default basato su codice ISBN.
//			 * 
//			 * @param other oggetto da confrontare.
//			 * @return <strong>{@code -1}</strong> se {@code this} è minore di
//			 *         {@code other}, <strong>{@code 0}</strong> se sono uguali,
//			 *         <strong>{@code 1}</strong> se {@code other} è maggiore di
//			 *         {@code this}.
//			 */
//			@Override
//			public int compareTo(LibraryItem other) {
//				return isbn.compareTo(other.isbn);
//			}
		}


