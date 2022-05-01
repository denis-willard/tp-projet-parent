package fr.natsystem.tp.test.dataservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.DisabledIf;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.repository.PersonneRepository;
import fr.natsystem.tp.data.services.PersonneDataService;
import fr.natsystem.tp.data.specification.PersonneSpecification;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testApplicationContext.xml")
public class PersonneTest {

	@Autowired
	PersonneRepository repo;
	
	@Autowired
	PersonneDataService dataservice;
	
	@Test
	@Ignore
	public void testPersonnes1998() {
		Specification<Personne> spec = Specification.where(
				PersonneSpecification.getPersonneParAnneeNaissance(1998L));
		
		List<Personne> result = repo.findAll(spec);
		
		assertNotNull(result);
		assertEquals(3, result.size());
	}
	
	@Test
	@Ignore
	public void testDeletePersonnes( ) {
		int n = dataservice.deletePersonnesByNomContaining("MARTIN");
		assertEquals(2, n);
	}
}
