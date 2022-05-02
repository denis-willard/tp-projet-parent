package fr.natsystem.tp.rest.dto;

import javax.validation.constraints.Size;

import fr.natsystem.tp.core.validators.NeCommencePasParX;

public class RegionDTO {

	private Long id;

	@Size(max = 255, message = "Le nom de région ne doit pas dépasser 255 caractères.")
	@NeCommencePasParX
	private String nomRegion;
	private String description;
	
	public RegionDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNomRegion() {
		return nomRegion;
	}
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
