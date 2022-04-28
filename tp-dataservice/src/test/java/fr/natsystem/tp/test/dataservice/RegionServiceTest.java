package fr.natsystem.tp.test.dataservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.data.repository.RegionRepository;
import fr.natsystem.tp.data.specification.RegionSpecification;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testApplicationContext.xml")
public class RegionServiceTest {

	@Autowired
	private RegionRepository repo;
	
	@Test
	public void testInsertRegion() {
		Region region = new Region("Bordeaux");
		Region result = repo.save(region);
		assertNotNull(result);
	}
	
	
	@Test
	public void testUpdateRegion() {
		Region region = new Region("Bourgogne");
		region.setId(21L);
		Region result = repo.save(region);
		assertNotNull(result);
	}
	
	
	@Test
	public void testGetRegions() {
		List<Region> result = repo.findAll();
		assertNotNull("le findAll() n'a rien ramené", result);
	}
	
	
	@Test
	public void testGetRegions2() {
				List<Region> result = repo.findAllByIdInOrderByNom( List.of(21L, 22L) );
		assertNotNull("le findAllByIdInOrderByNom() n'a rien ramené", result);
	}

	@Test
	public void testGetRegions3() {
		List<Region> result = repo.getAllByNom("Bourgogne");
		assertNotNull("le getAllByNom() n'a rien ramené", result);
		assertEquals(1, result.size());
	}

	@Test
	public void testGetRegions4() {
		List<Region> result = repo.getAllByNomNatif("Bourgogne");
		assertNotNull("le getAllByNomNatif() n'a rien ramené", result);
		assertEquals(1, result.size());
	}


	@Test
	public void testGetRegions5() {
		Specification<Region> spec = Specification.where(
				RegionSpecification.getRegionByNom("Bourgogne"))
				.and(RegionSpecification.getRegionByIdInferieurA(50L));

		List<Region> result = repo.findAll(spec);
		
		assertNotNull("le getAllByNomNatif() n'a rien ramené", result);
		assertEquals(1, result.size());
	}

}
