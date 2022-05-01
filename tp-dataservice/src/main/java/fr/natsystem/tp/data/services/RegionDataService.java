package fr.natsystem.tp.data.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.data.repository.RegionRepository;
import fr.natsystem.tp.data.specification.RegionCriteriaUpdate;

@Service
public class RegionDataService {
	
	@Autowired
	RegionRepository repo;
	
	@Autowired
	private EntityManager em;
	
	@Transactional
	public int updateNomRegion(Long id, String nouveauNom) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaUpdate<Region> criteriaUpdate = RegionCriteriaUpdate.getUpdateNomById(criteriaBuilder, id, nouveauNom);
	
		return em.createQuery(criteriaUpdate).executeUpdate();
	}
	
	@Transactional
	public Region getRegionById(Long id ) {
		Optional<Region> temp = repo.findById(id);
		if (temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	@Transactional
	public List<Region> getAllRegions() {
		return repo.findAll();
	}
	

	@Transactional
	public void deleteRegionById(Long id) {
		repo.deleteById(id);
	}

}
