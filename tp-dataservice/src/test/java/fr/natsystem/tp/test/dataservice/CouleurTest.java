package fr.natsystem.tp.test.dataservice;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.natsystem.tp.data.models.Couleur;
import fr.natsystem.tp.data.repository.CouleurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testApplicationContext.xml")
public class CouleurTest {

	@Autowired
	private CouleurRepository repo;
	
	@Test
	@Ignore
	public void testSaveCouleur() {
		Couleur couleur = new Couleur("Asdfqsd", "ABC");
		Couleur result = repo.save(couleur);
		assertNotNull(result);
	}

	
}
