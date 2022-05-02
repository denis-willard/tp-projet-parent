package fr.natsystem.tp.data.services;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.data.repository.PersonneRepository;
import fr.natsystem.tp.data.specification.PersonneCriteriaDelete;

@Service
public class PersonneDataService {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private PersonneRepository repo;
	
	
	@Transactional
	public int deletePersonnesByNomContaining(String nom) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<Personne> criteriaDelete = PersonneCriteriaDelete.getDeletePersonne(cb, nom);
		return em.createQuery(criteriaDelete).executeUpdate();
	}
	

	@Transactional
	public Page<Personne> getPersonnesParPage(int page, int size, String sortOrder) {
		final Pageable pageable = PageRequest.of(page,  size, Sort.unsorted());
		
		Page<Personne> personnes = repo.findAll(pageable);
		if (!personnes.isEmpty()) {
			return personnes;
		} else {
			return null;
		}
		
	}

}
