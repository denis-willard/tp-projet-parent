package fr.natsystem.tp.test.rest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.natsystem.tp.rest.dto.RegionDTO;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration({ "/testApplicationContext.xml" })
public class GetRegionTest {
	
	private static final String BASE_URI="/regions";

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@BeforeAll
	public void before( ) {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testGetRegions() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get(BASE_URI)).andExpect(status().isOk());
	}
	
    
    @Test
    public void testPostRegion( ) throws Exception {
    	
    	// construction du dto en entrée
    	RegionDTO dto = new RegionDTO();
    	dto.setNomRegion("Côte du Rhone");
    	
    	// serialisation en JSon
    	final String regionDTO_JSON = mapper.writeValueAsString(dto);
    	
    	mockMvc.perform(MockMvcRequestBuilders.post(BASE_URI)
    				.contentType(MediaType.APPLICATION_JSON)
    				.content(regionDTO_JSON))
    	.andExpect(status().isOk())
    	.andReturn();
    }


}
