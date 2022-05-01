package fr.natsystem.tp.data.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import fr.natsystem.tp.data.models.Region;

public class RegionCriteriaUpdate {

	// UPDATE T_REGION SET NOM = :nouveauNom WHERE ID = :id 

	public static CriteriaUpdate<Region> getUpdateNomById(CriteriaBuilder criteriaBuilder, Long id, String nouveauNom) {
		if (id == null || criteriaBuilder == null) {
			return null;
		}
		
		CriteriaUpdate<Region> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Region.class);
		Root<Region> root = criteriaUpdate.from(Region.class);
		criteriaUpdate
			.set(root.get("nom"), nouveauNom)
			.where(criteriaBuilder.equal(root.get("id"), id));
		return criteriaUpdate;
	}

}
