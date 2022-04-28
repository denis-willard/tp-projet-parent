package fr.natsystem.tp.data.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import fr.natsystem.tp.data.models.Personne;

public class PersonneSpecification {
	
	// Select ... from T_PERSONNE WHERE (NOM LIKE '%MARTIN%' OR PRENOM LIKE '%MARTIN%'
	
	public static Specification<Personne> getPersonneAvecNomOuPrenomContenant(String valeur) {
		List<Predicate> predicates = new ArrayList<>();
		if (StringUtils.isBlank(valeur))
			return null;

		return (root, query, criteriaBuilder) -> {
			predicates.add(criteriaBuilder.like(root.get("identite").get("nom"), "%" + valeur + "%"));
			predicates.add(criteriaBuilder.like(root.get("identite").get("prenom"), "%" + valeur + "%"));
			return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
		};
	}

	// Select ... from T_PERSONNE WHERE EXTRACT( YEAR FROM DATE_NAISSANCE ) = 1998

	public static Specification<Personne> getPersonneParAnneeNaissance(Long anneeNaissance) {
		List<Predicate> predicates = new ArrayList<>();
		if (anneeNaissance == null)
			return null;

		return (root, query, criteriaBuilder) -> {
			predicates.add(criteriaBuilder.equal(
					criteriaBuilder.function("YEAR", Long.class, root.get("identite").get("dateNaissance")),
					anneeNaissance));
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};

	}

}
