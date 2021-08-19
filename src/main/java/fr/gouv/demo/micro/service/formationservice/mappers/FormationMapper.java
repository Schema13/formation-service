package fr.gouv.demo.micro.service.formationservice.mappers;

import org.mapstruct.Mapper;

import fr.gouv.demo.micro.service.formationservice.dto.FormationRequestDto;
import fr.gouv.demo.micro.service.formationservice.dto.FormationResponseDto;
import fr.gouv.demo.micro.service.formationservice.entities.Formation;

@Mapper(componentModel = "spring")
public interface FormationMapper {

	Formation formationRequestDtoToFormation(FormationRequestDto formationRequestDto);
	
	FormationResponseDto FormationToFormationResponseDto(Formation formation);
}
