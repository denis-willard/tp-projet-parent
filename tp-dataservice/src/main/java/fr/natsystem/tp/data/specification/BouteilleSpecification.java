package fr.natsystem.tp.data.specification;

import javax.persistence.criteria.Join;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import fr.natsystem.tp.data.models.Bouteille;
import fr.natsystem.tp.data.models.Region;

public class BouteilleSpecification {

	// Select ... from T_BOUTEILLE B, T_REGION R WHERE R.ID = B.REGION_RF AND R.NOM = :nomRegion

	public static Specification<Bouteille> getBouteilleParNomRegion(String nomRegion) {
		if (StringUtils.isBlank(nomRegion))
			return null;
		return (root, query, criteriaBuilder) -> {
			Join<Bouteille, Region> joinRegion = root.join("region");
			return criteriaBuilder.equal(joinRegion.get("nom"), nomRegion);
		};
	}

}
