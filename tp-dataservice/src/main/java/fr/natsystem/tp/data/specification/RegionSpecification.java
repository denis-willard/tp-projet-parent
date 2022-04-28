package fr.natsystem.tp.data.specification;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import fr.natsystem.tp.data.models.Region;

public class RegionSpecification {

	// Select ... from T_REGION WHERE ID = :id
	
	public static Specification<Region> getRegionById(Long id) {
		if (id == null) 
			return null;
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	// Select ... from T_REGION WHERE ID <= :id
	
	public static Specification<Region> getRegionByIdInferieurA(Long id) {
		if (id == null) 
			return null;
		return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("id"), id);
	}

	// Select ... from T_REGION WHERE NOM = :nom
	
	public static Specification<Region> getRegionByNom(String nom) {
		if (StringUtils.isBlank(nom))
			return null;
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nom"), nom);
	}

	// Select ... from T_REGION WHERE NOM like "%MARTIN%"
	
	public static Specification<Region> getRegionByNomContaining(String nom) {
		if (StringUtils.isBlank(nom))
			return null;
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nom"), "%" + nom + "%");
	}

}
