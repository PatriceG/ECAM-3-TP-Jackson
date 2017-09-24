package fr.ecam;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {
	private long id;
	private String nom;
	private String prénom;

	@JsonProperty("date-de-naissance")
	private Date dateDeNaissance;
	private List<Adresse> adresses;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrénom() {
		return prénom;
	}

	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		return "Contact [adresses=" + adresses + ", dateDeNaissance="
				+ dateDeNaissance + ", id=" + id + ", nom=" + nom + ", prénom="
				+ prénom + "]";
	}
	
	

}
