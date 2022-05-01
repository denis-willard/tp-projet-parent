package fr.natsystem.tp.data.services;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.specification.PersonneCriteriaDelete;

@Service
public class PersonneDataService {

	@Autowired
	private EntityManager em;
	
	@Transactional
	public int deletePersonnesByNomContaining(String nom) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<Personne> criteriaDelete = PersonneCriteriaDelete.getDeletePersonne(cb, nom);
		return em.createQuery(criteriaDelete).executeUpdate();
	}
}
