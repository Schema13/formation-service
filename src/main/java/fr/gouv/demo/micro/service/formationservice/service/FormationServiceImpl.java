package fr.gouv.demo.micro.service.formationservice.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gouv.demo.micro.service.formationservice.dto.FormationRequestDto;
import fr.gouv.demo.micro.service.formationservice.dto.FormationResponseDto;
import fr.gouv.demo.micro.service.formationservice.entities.Agent;
import fr.gouv.demo.micro.service.formationservice.entities.Formation;
import fr.gouv.demo.micro.service.formationservice.mappers.FormationMapper;
import fr.gouv.demo.micro.service.formationservice.openfeign.AgentRestClient;
import fr.gouv.demo.micro.service.formationservice.repository.FormationRepository;

@Service
@Transactional
public class FormationServiceImpl implements FormationService {

	@Autowired
	private FormationRepository formationRepository;
	
	@Autowired
	private FormationMapper formationMapper;
	
	@Autowired
	private AgentRestClient agentRestClient;
	
	@Override
	public FormationResponseDto save(FormationRequestDto formationRequestDto) {
		Formation formation = formationMapper.formationRequestDtoToFormation(formationRequestDto);
		formation.setId(UUID.randomUUID().toString());
		return this.formationMapper.FormationToFormationResponseDto(this.formationRepository.save(formation));
	}

	@Override
	public FormationResponseDto getFormation(String formationId) {
		Formation formation = this.formationRepository.findById(formationId).get();
		// Communication avec agent-service dans une autre base de données
		Agent agent = this.agentRestClient.getAgent(formation.getAgentId());
		formation.setAgent(agent);
		return this.formationMapper.FormationToFormationResponseDto(formation);
	}

	@Override
	public List<FormationResponseDto> formationParAgentId(String agentId) {
		List<Formation> formations = this.formationRepository.findByAgentId(agentId);
		return formations.stream()
				.map(f -> this.formationMapper.FormationToFormationResponseDto(f))
				.collect(Collectors.toList());
	}

}
