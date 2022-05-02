package fr.natsystem.tp.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.natsystem.tp.core.exception.NotFoundException;
import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.data.services.RegionDataService;
import fr.natsystem.tp.rest.dto.ListePagineeDTO;
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
	public ListePagineeDTO<RegionDTO> getToutesLesRegions(
			@RequestParam(name = "nomRegion", required = false) String nomRegion,
			@RequestParam(name = "size", required = true) int size,
			@RequestParam(name = "page", required = true) int page,
			@RequestParam(name = "sort_order", required = false) String sortOrder
			) {
		Page<Region> regions = dataservice.getRegionParPage(nomRegion, page, size, sortOrder);
			
		ListePagineeDTO<RegionDTO> resultDTO;
		
		if (regions == null) {
			resultDTO = new ListePagineeDTO<RegionDTO>(new ArrayList<>(), 0, 0);			
		} else {
			List<RegionDTO> listeRegionsDTO = mapper.convertToDtos(regions.getContent());
			resultDTO = new ListePagineeDTO<RegionDTO>(listeRegionsDTO, regions.getNumber(), regions.getTotalElements());
		}
		
		return resultDTO;
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RegionDTO postRegion(@RequestBody RegionDTO dto) {
		Region region = mapper.convertToEntity(dto);
		Region result = dataservice.createRegion(region);
		return mapper.convertToDto(result);
	}


	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RegionDTO putRegion(
			@PathVariable("id") Long id,
			@RequestBody RegionDTO dto) {
		Region region = mapper.convertToEntity(dto);
		region.setId(id);
		Region result = dataservice.saveRegion(region);
		return mapper.convertToDto(result);
	}

	

	@ResponseStatus(code = HttpStatus.OK)
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RegionDTO patchRegion(
			@PathVariable("id") Long id,
			@RequestBody RegionDTO dto) {
		Region region = mapper.convertToEntity(dto);
		region.setId(id);
		Region result = dataservice.saveRegion(region);
		return mapper.convertToDto(result);
	}

	


	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping(path = "/{id}")
	public void deleteRegion(@PathVariable("id") Long id) {
		dataservice.deleteRegionById(id);
	}


}
