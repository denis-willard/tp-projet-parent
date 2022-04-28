package fr.natsystem.tp.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="T_BOUTEILLE")
@NamedEntityGraphs({
	@NamedEntityGraph(
			name = "bouteilleEtCeQuiVaAvec",
			attributeNodes = {
					@NamedAttributeNode("region"),
					@NamedAttributeNode("couleur")
			})
})
public class Bouteille {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SQ_BOUTEILLE")
	@SequenceGenerator(name = "SQ_BOUTEILLE", sequenceName="SQ_BOUTEILLE", allocationSize=1)
	private Long id;
	
	@Size(max = 255)
	@Column(name = "NOM")
	private String nom;
	
	@Column(name = "NB_BOUTEILLES")
	private Long nbBouteilles;
	
	@Column(name = "CONTENANCE")
	private Long contenance;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "REGION_RF", referencedColumnName="ID")
	private Region region;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COULEUR_RF", referencedColumnName="ID")
	private Couleur couleur;
	
	
	
	public Bouteille() {
		super();
	}

	public Bouteille(String nom) {
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

	public Long getNbBouteilles() {
		return nbBouteilles;
	}

	public void setNbBouteilles(Long nbBouteilles) {
		this.nbBouteilles = nbBouteilles;
	}

	public Long getContenance() {
		return contenance;
	}

	public void setContenance(Long contenance) {
		this.contenance = contenance;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

}
