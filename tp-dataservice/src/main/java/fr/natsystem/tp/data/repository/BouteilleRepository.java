package fr.natsystem.tp.data.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.natsystem.tp.data.models.Bouteille;

@Repository
public interface BouteilleRepository extends JpaRepository<Bouteille, Long> {
	
	List<Bouteille> findAll(Specification<Bouteille> spec);

}
