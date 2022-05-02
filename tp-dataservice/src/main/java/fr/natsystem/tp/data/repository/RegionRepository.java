package fr.natsystem.tp.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.natsystem.tp.data.models.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
	
	List<Region> findAll(Specification<Region> spec);
	
	List<Region> findAllByIdInOrderByNom(List<Long> ids);
	
	@Query(value = "SELECT r from Region r WHERE r.nom = :nom")
	List<Region> getAllByNom(@Param("nom") String nom);
	
	@Query(value = "SELECT * from T_REGION WHERE nom = :nom", nativeQuery = true)
	List<Region> getAllByNomNatif(@Param("nom") String nom);
	
	// liste paginée
	Page<Region> findAllByNom(String nom, Pageable pageable);
}
