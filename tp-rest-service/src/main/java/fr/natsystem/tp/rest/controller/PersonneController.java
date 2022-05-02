package fr.natsystem.tp.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.services.PersonneDataService;
import fr.natsystem.tp.rest.dto.ListePagineeDTO;
import fr.natsystem.tp.rest.dto.PersonneDTO;
import fr.natsystem.tp.rest.mappers.PersonneMapper;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

	@Autowired
	private PersonneDataService dataservice;
	
	@Autowired
	private PersonneMapper mapper;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ListePagineeDTO<PersonneDTO>  getToutesLesPersonnes(
			@RequestParam(name = "size", required = true) int size,
			@RequestParam(name = "page", required = true) int page,
			@RequestParam(name = "sort_order", required = false) String sortOrder
			) {
		Page<Personne> personnes = dataservice.getPersonnesParPage(page, size, sortOrder);
		
		ListePagineeDTO<PersonneDTO> resultDTO;
		
		if (personnes == null) {
			resultDTO = new ListePagineeDTO<PersonneDTO>(new ArrayList<>(), 0, 0);			
		} else {
			List<PersonneDTO> listePersonnesDTO = mapper.convertToDtos(personnes.getContent());
			resultDTO = new ListePagineeDTO<PersonneDTO>(listePersonnesDTO, personnes.getNumber(), personnes.getTotalElements());
		}
		
		return resultDTO;
	}

	
}
