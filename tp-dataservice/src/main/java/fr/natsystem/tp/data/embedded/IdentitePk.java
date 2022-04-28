package fr.natsystem.tp.data.embedded;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class IdentitePk implements Serializable {
	private static final long serialVersionUID = -5328472929902167114L;

	@Size(max = 50)
	@Column(name = "NOM")
	private String nom;
	
	@Size(max = 50)
	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "DATE_NAISSANCE")
	private LocalDate dateNaissance;

	public IdentitePk() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
