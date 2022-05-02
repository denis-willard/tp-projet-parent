package fr.natsystem.tp.data.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public Region createRegion(Region region) {
		region.setId(null);
		return repo.save(region);
	}
	
	@Transactional
	public Region saveRegion(Region region) {
		return repo.save(region);
	}
	
	@Transactional
	public int updateNomRegion(Long id, String nouveauNom) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaUpdate<Region> criteriaUpdate = RegionCriteriaUpdate.getUpdateNomById(criteriaBuilder, id, nouveauNom);
	
		return em.createQuery(criteriaUpdate).executeUpdate();
	}
	
	@Transactional
	public Region getRegionById(Long id) {
		Optional<Region> temp = repo.findById(id);
		if (temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	@Transactional
	public List<Region> getAllRegionsParNomRegion(String nomRegion) {
		if (StringUtils.isBlank(nomRegion)) {
			return repo.findAll();			
		} else {
			return repo.getAllByNom(nomRegion);
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

	@Transactional
	public Page<Region> getRegionParPage(String nomRegion, int page, int size, String sortOrder) {
		final Pageable pageable = PageRequest.of(page,  size, Sort.unsorted());
		
		Page<Region> regions = repo.findAll(pageable);
		if (!regions.isEmpty()) {
			return regions;
		} else {
			return null;
		}
		
	}
}
