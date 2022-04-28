package fr.natsystem.tp.data.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.natsystem.tp.data.embedded.Adresse;
import fr.natsystem.tp.data.embedded.IdentitePk;

@Entity
@Table(name="T_PERSONNE")
public class Personne {

	@EmbeddedId
	private IdentitePk identite;
	
	@Embedded
	private Adresse adressePrincipale;
	
	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(name = "adresse", column = @Column(name = "ADRESSE2") ),
			@AttributeOverride(name = "codePostal", column = @Column(name = "CODE_POSTAL2") ),
			@AttributeOverride(name = "localite", column = @Column(name = "LOCALITE2") )
	})
			
	private Adresse adresseSecondaire;

	public Personne() {
		super();
	}

	public IdentitePk getIdentite() {
		return identite;
	}

	public void setIdentite(IdentitePk identite) {
		this.identite = identite;
	}

	
	public Adresse getAdressePrincipale() {
		return adressePrincipale;
	}

	public void setAdressePrincipale(Adresse adressePrincipale) {
		this.adressePrincipale = adressePrincipale;
	}

	public Adresse getAdresseSecondaire() {
		return adresseSecondaire;
	}

	public void setAdresseSecondaire(Adresse adresseSecondaire) {
		this.adresseSecondaire = adresseSecondaire;
	}
	
	
}
