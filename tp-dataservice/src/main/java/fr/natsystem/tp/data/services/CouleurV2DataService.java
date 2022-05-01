package fr.natsystem.tp.data.services;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.natsystem.tp.core.utilities.CouleurEnum;
import fr.natsystem.tp.data.models.CouleurV2;
import fr.natsystem.tp.data.repository.CouleurV2Repository;

@Service
public class CouleurV2DataService implements Serializable {
	private static final long serialVersionUID = -2276139062930532654L;

	@Autowired
	CouleurV2Repository repo;
	
	@Transactional
	public CouleurV2 enregistreCouleur(CouleurV2 couleur) {
		return repo.save(couleur);
	}

	
	@Transactional
	public CouleurV2 enregistreCouleur(CouleurEnum couleur, Boolean petillant) {
		CouleurV2 result = new CouleurV2(couleur, petillant);
		return repo.save(result);
	}

}
