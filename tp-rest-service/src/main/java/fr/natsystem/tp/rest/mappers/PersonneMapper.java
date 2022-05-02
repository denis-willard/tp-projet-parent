package fr.natsystem.tp.rest.mappers;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.rest.dto.PersonneDTO;
import fr.natsystem.tp.rest.dto.RegionDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel="spring")
public interface PersonneMapper {
	RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

	PersonneDTO convertToDto(Personne entity);
	@AfterMapping
	default void afterMapping(@MappingTarget PersonneDTO dto, Personne entity) {
		dto.setNom(entity.getIdentite().getNom());
		dto.setPrenom(entity.getIdentite().getPrenom());
		dto.setDateNaissance(entity.getIdentite().getDateNaissance());
		
		dto.setAdresse(entity.getAdressePrincipale().getAdresse());
		dto.setCodePostal(entity.getAdressePrincipale().getCodePostal());
		dto.setLocalite(entity.getAdressePrincipale().getLocalite());
	}


	
	List<PersonneDTO> convertToDtos(List<Personne> entities);

	Personne convertToEntity(PersonneDTO dto);
}
