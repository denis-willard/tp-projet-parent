package fr.natsystem.tp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.data.services.RegionDataService;
import fr.natsystem.tp.rest.dto.RegionDTO;
import fr.natsystem.tp.rest.mappers.RegionMapper;

@RestController
@RequestMapping("/regions")
public class RegionController {

	@Autowired
	private RegionDataService dataservice;
	
	@Autowired RegionMapper mapper;
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RegionDTO getRegionById(@PathVariable("id") Long id) {
		Region region = dataservice.getRegionById(id);
		return mapper.convertToDto(region);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RegionDTO> getToutesLesRegions() {
		List<Region> regions = dataservice.getAllRegions();
		return mapper.convertToDtos(regions);
	}
}
