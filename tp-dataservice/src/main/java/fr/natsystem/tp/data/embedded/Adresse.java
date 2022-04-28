package fr.natsystem.tp.data.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Adresse implements Serializable {
	private static final long serialVersionUID = -5328472929902167114L;

	@Size(max = 255)
	@Column(name = "ADRESSE1")
	private String adresse;
	
	@Size(max = 10)
	@Column(name = "CODE_POSTAL1")
	private String codePostal;
	
	@Size(max = 40)
	@Column(name = "LOCALITE1")
	private String localite;

	public Adresse() {
		super();
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}
	

}
