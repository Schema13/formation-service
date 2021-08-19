package fr.gouv.demo.micro.service.formationservice.service;

import java.util.List;

import fr.gouv.demo.micro.service.formationservice.dto.FormationRequestDto;
import fr.gouv.demo.micro.service.formationservice.dto.FormationResponseDto;

public interface FormationService {

	FormationResponseDto save(FormationRequestDto formationRequestDto);
	
	FormationResponseDto getFormation(String formationId);
	
	List<FormationResponseDto> formationParAgentId(String agentId);
}
