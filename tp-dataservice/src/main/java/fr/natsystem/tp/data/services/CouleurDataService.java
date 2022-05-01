package fr.natsystem.tp.data.services;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.natsystem.tp.data.models.Couleur;
import fr.natsystem.tp.data.repository.CouleurRepository;

@Service
public class CouleurDataService implements Serializable {
	private static final long serialVersionUID = -2276139062930532654L;
	
	@Autowired
	private EntityManager em;

	@Autowired
	private CouleurRepository couleurRepository;
	
	
	@Transactional
	public Couleur saveCouleur(Couleur couleur) {
		return couleurRepository.save(couleur);
	}
	
}
