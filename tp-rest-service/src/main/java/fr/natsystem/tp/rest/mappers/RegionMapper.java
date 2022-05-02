package fr.natsystem.tp.rest.mappers;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.rest.dto.RegionDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel="spring")
public interface RegionMapper {
	RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

	@Mapping(source = "nom", target = "nomRegion")
	RegionDTO convertToDto(Region entity);
	@AfterMapping
	default void afterMapping(@MappingTarget RegionDTO dto, Region entity) {
		dto.setDescription(entity.getId().toString() + ": " + entity.getNom());
	}
	
	List<RegionDTO> convertToDtos(List<Region> entities);
	
	
	@Mapping(source = "nomRegion", target = "nom")
	Region convertToEntity(RegionDTO dto);
}
