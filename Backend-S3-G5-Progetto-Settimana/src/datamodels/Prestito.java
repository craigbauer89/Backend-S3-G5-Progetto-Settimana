package datamodels;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
public class Prestito {
	
	private int id;
	private Utente utente;
	private List<CatalogElemento> catologoItem;
	private Date inizioPrestito;
	private Date restituzionePrestito; // (calcolata automaticamente a 30 gg dalla data inizio prestito)
	private Date restituzioneEffettiva;
	
	
	public Prestito(int id, Utente utente, Date inizioPrestito, Date restituzionePrestito,
			Date restituzioneEffettiva) {
		this.id = id;
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

	public Date getInizioPrestito() {
		return inizioPrestito;
	}

	public void setInizioPrestito(Date inizioPrestito) {
		this.inizioPrestito = inizioPrestito;
	}

	public Date getRestituzionePrestito() {
		return restituzionePrestito;
	}

	public void setRestituzionePrestito(Date restituzionePrestito) {
		this.restituzionePrestito = restituzionePrestito;
	}

	public Date getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}

	public void setRestituzioneEffettiva(Date restituzioneEffettiva) {
		this.restituzioneEffettiva = restituzioneEffettiva;
	}

	@Override
	public String toString() {
		return String.format(
				"Prestito [id=%s, utente=%s, catologoItem=%s, inizioPrestito=%s, restituzionePrestito=%s, restituzioneEffettiva=%s]",
				id, utente, catologoItem, inizioPrestito, restituzionePrestito, restituzioneEffettiva);
	}

	

}

