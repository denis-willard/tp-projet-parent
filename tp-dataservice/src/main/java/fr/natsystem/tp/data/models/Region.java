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

@Entity
@Table(name = "T_REGION")
public class Region {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SQ_REGION")
	@SequenceGenerator(name = "SQ_REGION", sequenceName="SQ_REGION", allocationSize=1)
	private Long id;
	
	@NotNull(message = "le nom est obligatoire")
	@Size(max = 255, message="La taille du nom est limitée à 255 caractères")
	@Column(name = "NOM")
	private String nom;

	public Region() {
		super();
	}
	
	public Region(String nom) {
		super();
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
