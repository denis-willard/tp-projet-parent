package fr.natsystem.tp.test.dataservice;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.natsystem.tp.core.utilities.CouleurEnum;
import fr.natsystem.tp.data.models.CouleurV2;
import fr.natsystem.tp.data.repository.CouleurV2Repository;
import fr.natsystem.tp.data.services.CouleurV2DataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testApplicationContext.xml")
public class CouleurV2Test {

	@Autowired
	private CouleurV2Repository repo;
	
	@Autowired
	private CouleurV2DataService dataservice;
	
	@Test
	public void testSaveCouleur() {
		CouleurV2 result = dataservice.enregistreCouleur(CouleurEnum.BIERE_ENUM, Boolean.TRUE); 
		assertNotNull(result);
	}

	
}
