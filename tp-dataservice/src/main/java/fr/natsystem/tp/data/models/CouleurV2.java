package fr.natsystem.tp.data.models;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fr.natsystem.tp.core.converter.BooleanToStringOuiNonConverter;
import fr.natsystem.tp.core.converter.CouleurEnumToStringConverter;
import fr.natsystem.tp.core.utilities.CouleurEnum;

@Entity
@Table(name="T_COULEUR")
public class CouleurV2 {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SQ_COULEUR")
	@SequenceGenerator(name = "SQ_COULEUR", sequenceName="SQ_COULEUR", allocationSize=1)
	private Long id;

	@NotNull
	@Convert(converter = CouleurEnumToStringConverter.class)
	@Column(name = "COULEUR")
	private CouleurEnum couleur;
	
	@Convert(converter = BooleanToStringOuiNonConverter.class)
	@Column(name = "PETILLANT")
	private Boolean petillant;
	
	public CouleurV2() {
		super();
	}

	public CouleurV2(CouleurEnum couleur, Boolean petillant) {
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
	public CouleurEnum getCouleur() {
		return couleur;
	}
	public void setCouleur(CouleurEnum couleur) {
		this.couleur = couleur;
	}
	public Boolean getPetillant() {
		return petillant;
	}
	public void setPetillant(Boolean petillant) {
		this.petillant = petillant;
	}
	
}
