package datamodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
//@NamedQuery(name = "Utente.SELECT_ELEMENTO_BY_TESSERA", query = "SELECT u FROM Utente u JOIN  p.prestito u WHERE u.tessera = :tessera")
public class Utente {
	
	private int id;
	private String nome;
	private String  cognome;
	private int dataNascita;
	private String numeroTessera;
	
	
	public Utente(int id,String nome, String cognome, int dataNascita, String numeroTessera) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.numeroTessera = numeroTessera;
	}
	
	public Utente(String nome, String cognome, int dataNascita, String numeroTessera) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.numeroTessera = numeroTessera;
	}
	
	
	public Utente() {

		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public int getDataNascita() {
		return dataNascita;
	}


	public void setDataNascita(int dataNascita) {
		this.dataNascita = dataNascita;
	}


	public String getNumeroTessera() {
		return numeroTessera;
	}


	public void setNumeroTessera(String numeroTessera) {
		this.numeroTessera = numeroTessera;
	}


	@Override
	public String toString() {
		return String.format("Utente [id=%s, nome=%s, cognome=%s, dataNascita=%s, numeroTessera=%s]", id, nome, cognome,
				dataNascita, numeroTessera);
	}


	
	
	
	

}

