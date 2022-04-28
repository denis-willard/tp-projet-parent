package fr.natsystem.tp.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.natsystem.tp.data.embedded.IdentitePk;
import fr.natsystem.tp.data.models.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, IdentitePk> {

	List<Personne> findAll(Specification<Personne> spec);

	Page<Personne> findAll(Specification<Personne> spec, Pageable pageable);
}
