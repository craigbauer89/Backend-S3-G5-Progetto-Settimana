package datamodels;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;





	@Entity
	@Inheritance(strategy = InheritanceType.JOINED)
	@Table(name = "catologoItems")
	@NamedQuery(name = "CatalogElemento.SELECT_ALL_QUERY", query = "SELECT c FROM CatalogElemento c")
	@NamedQuery(name = "CatalogElemento.SELECT_ELEMENTO_BY_ISBN", query = "SELECT c FROM CatalogElemento c WHERE c.codiceISBN.codiceISBN = :sigla")
	@NamedQuery(name = "CatalogElemento.SELECT_ELEMENTO_BY_ANNO", query = "SELECT c FROM CatalogElemento c WHERE c.annoPubblicato.annoPubblicato = :anno")
	@NamedQuery(name = "CatalogElemento.SELECT_ELEMENTO_BY_TITOLO", query = "SELECT c FROM CatalogElemento c WHERE c.titolo.titolo LIKE :titolo")
	@NamedQuery(name = "CatalogElemento.SELECT_ELEMENTO_BY_TESSERA", query = "SELECT c FROM CatalogElemento c WHERE c.prestito IN(SELECT p FROM Prestito p WHERE p.utente IN(SELECT u FROM Utente u WHERE u.numeroTessera = :tessera) AND p.restituzionePrestito > :today) ")
	@NamedQuery(name = "CatalogElemento.SELECT_ELEMENTO_BY_SCADUTA", 
	query = "SELECT c FROM CatalogElemento c WHERE c.prestito IN(SELECT p FROM Prestito p WHERE p.restituzioneEffettiva > :thirtydaysfromtoday)")
		public abstract class CatalogElemento { //implements  {
			
//			private int id;
			private String codiceISBN;
			private String titolo;
			private int annoPubblicato;
			private int numeroPagine;
			private Prestito prestito;
			
//			public CatalogElemento(int id, String codiceISBN, String titolo, int annoPubblicato, int numeroPagine, Prestito prestito) {
//				this.id = id;
//				this.codiceISBN = codiceISBN;
//				this.titolo = titolo;
//				this.annoPubblicato = annoPubblicato;
//				this.numeroPagine = numeroPagine;
//				this.prestito = prestito;
//				
//			}
			
			public CatalogElemento(String codiceISBN, String titolo, int annoPubblicato, int numeroPagine, Prestito prestito) {
				this.codiceISBN = codiceISBN;
				this.titolo = titolo;
				this.annoPubblicato = annoPubblicato;
				this.numeroPagine = numeroPagine;
				this.prestito = prestito;
				
			}
			
			public CatalogElemento() {

			}
			
			
//			public int getId() {
//				return id;
//			}
//
//			public void setId(int id) {
//				this.id = id;
//			}
			@Id
//			@GeneratedValue(strategy = GenerationType.IDENTITY)
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
						"CatologoItem [codiceISBN=%s, titolo=%s, annoPubblicato=%s, numeroPagine=%s, prestito=%s]",
						codiceISBN, titolo, annoPubblicato, numeroPagine, prestito);
			}

		
			

		}


