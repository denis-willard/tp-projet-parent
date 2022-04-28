package fr.natsystem.tp.data.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.natsystem.tp.data.models.CouleurV2;

@Repository
public interface CouleurV2Repository extends JpaRepository<CouleurV2, Long> {
	
	List<CouleurV2> findAll(Specification<CouleurV2> spec);
	
}
