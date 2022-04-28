package fr.natsystem.tp.data.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import fr.natsystem.tp.data.embedded.IdentitePk_;
import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.models.Personne_;

public class PersonneCriteriaDelete {
	
	// DELETE FROM T_PERSONNE WHERE ( NOM LIKE '%MARTIN%' OR PRENOM LIKE '%MARTIN%' )

	public static CriteriaDelete<Personne> getDeletePersonne(
			CriteriaBuilder cb,
			String valeur
			) {
		if (StringUtils.isBlank(valeur) || cb == null) return null;
		
		CriteriaDelete<Personne> criteriaDelete = cb.createCriteriaDelete(Personne.class);
		Root<Personne> root = criteriaDelete.from(Personne.class);
		
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.like(root.get("identite").get("nom"), "%" + valeur + "%"));
		predicates.add(cb.like(root.get("identite").get("prenom"), "%" + valeur + "%"));
		
		Expression<Boolean> expression = cb.or(predicates.toArray(new Predicate[0]));
		
		criteriaDelete.where(expression);
		return criteriaDelete;
	}
	

	// Variante avec utilisation de jpamodelgen

	public static CriteriaDelete<Personne> getDeletePersonneEnMieux(
			CriteriaBuilder cb,
			String valeur
			) {
		if (StringUtils.isBlank(valeur) || cb == null) return null;
		
		CriteriaDelete<Personne> criteriaDelete = cb.createCriteriaDelete(Personne.class);
		Root<Personne> root = criteriaDelete.from(Personne.class);
		
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.like(root.get(Personne_.IDENTITE).get(IdentitePk_.NOM), "%" + valeur + "%"));
		predicates.add(cb.like(root.get(Personne_.IDENTITE).get(IdentitePk_.PRENOM), "%" + valeur + "%"));
		
		Expression<Boolean> expression = cb.or(predicates.toArray(new Predicate[0]));
		
		criteriaDelete.where(expression);
		return criteriaDelete;
	}
	

}
