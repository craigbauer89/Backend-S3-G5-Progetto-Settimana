package datamodels;




import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
//@NamedQuery(name = "Prestito.SELECT_ELEMENTO_BY_TESSERA", 
//query = "SELECT p FROM Prestito p WHERE p.restituzioneEffettiva > :thirtydaysfromtoday ")
//@NamedQuery(name = "Prestito.SELECT_ELEMENTO_BY_TESSERA", 
//query = "SELECT p FROM Prestito p WHERE p.restituzionePrestito > :today ")
public class Prestito {
	
	private int id;
	private Utente utente;
	private List<CatalogElemento> catologoItem;
	private LocalDate inizioPrestito;
	private LocalDate restituzionePrestito; 
	private LocalDate restituzioneEffettiva;
	
	
	public Prestito(int id, Utente utente, LocalDate inizioPrestito, LocalDate restituzionePrestito,
			LocalDate restituzioneEffettiva) {
		this.id = id;
		this.utente = utente;
		this.inizioPrestito = inizioPrestito;
		this.restituzionePrestito = restituzionePrestito;
		this.restituzioneEffettiva = restituzioneEffettiva;
	}
	
	public Prestito(Utente utente, LocalDate inizioPrestito, LocalDate restituzionePrestito,
			LocalDate restituzioneEffettiva) {
		this.utente = utente;
		this.inizioPrestito = inizioPrestito;
		this.restituzionePrestito = restituzionePrestito;
		this.restituzioneEffettiva = restituzioneEffettiva;
	}


	public Prestito() {
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@OneToOne
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	@OneToMany (mappedBy="prestito", cascade = CascadeType.REMOVE)
	public List<CatalogElemento> getCatologoItem() {
		return catologoItem;
	}

	public void setCatologoItem(List<CatalogElemento> catologoItem) {
		this.catologoItem = catologoItem;
	}

	public LocalDate getInizioPrestito() {
		return inizioPrestito;
	}

	public void setInizioPrestito(LocalDate inizioPrestito) {
		this.inizioPrestito = inizioPrestito;
	}

	public LocalDate getRestituzionePrestito() {
		return restituzionePrestito;
	}

	public void setRestituzionePrestito(LocalDate restituzionePrestito) {
		this.restituzionePrestito = restituzionePrestito;
	}

	public LocalDate getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}

	public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
		this.restituzioneEffettiva = restituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito ID: [id=" + id + "]";
	}

	
	

}

