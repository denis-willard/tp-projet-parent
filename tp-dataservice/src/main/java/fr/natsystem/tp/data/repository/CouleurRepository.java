package fr.natsystem.tp.data.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.natsystem.tp.data.models.Couleur;

@Repository
public interface CouleurRepository extends JpaRepository<Couleur, Long > {
	
	List<Couleur> findAll(Specification<Couleur> spec);
	
}
