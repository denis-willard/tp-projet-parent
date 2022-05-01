package fr.natsystem.tp.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.natsystem.tp.data.annotations.OuiOuNon;

@Entity
@Table(name="T_COULEUR")
public class Couleur {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SQ_COULEUR")
	@SequenceGenerator(name = "SQ_COULEUR", sequenceName="SQ_COULEUR", allocationSize=1)
	private Long id;
	
	@NotNull
	@Column(name = "COULEUR")
	@Size(max = 255)
	private String couleur;
	
	@Column(name = "PETILLANT")
	@Size(max = 3)
	@OuiOuNon(message = "valeurs OUI ou NON pour le champ pétillant")
	private String petillant;

	public Couleur() {
		super();
	}

	public Couleur(@NotNull @Size(max = 255) String couleur, @Size(max = 3) String petillant) {
		super();
		this.couleur = couleur;
		this.petillant = petillant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getPetillant() {
		return petillant;
	}

	public void setPetillant(String petillant) {
		this.petillant = petillant;
	}	
	
}
