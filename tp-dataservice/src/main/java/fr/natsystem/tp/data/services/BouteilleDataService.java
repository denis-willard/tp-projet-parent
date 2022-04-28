package fr.natsystem.tp.data.services;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import fr.natsystem.tp.data.models.Bouteille;
import fr.natsystem.tp.data.repository.BouteilleRepository;
import fr.natsystem.tp.data.specification.BouteilleSpecification;

@Service
public class BouteilleDataService implements Serializable {
	
	private static final long serialVersionUID = -2276139062930532654L;

	@Autowired
	private BouteilleRepository bouteilleRepository;

	@Transactional
	public Bouteille saveBouteille(Bouteille bouteille) {
		return bouteilleRepository.save(bouteille);
	}

	@Transactional
	public List<Bouteille> getParNomRegion(String nom) {

		Specification<Bouteille> spec = Specification.where(BouteilleSpecification.getBouteilleParNomRegion(nom));

		List<Bouteille> result = bouteilleRepository.findAll(spec);

		return result;
	}

	
}
