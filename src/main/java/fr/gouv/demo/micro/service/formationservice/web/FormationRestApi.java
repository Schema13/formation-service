package fr.gouv.demo.micro.service.formationservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gouv.demo.micro.service.formationservice.dto.FormationRequestDto;
import fr.gouv.demo.micro.service.formationservice.dto.FormationResponseDto;
import fr.gouv.demo.micro.service.formationservice.service.FormationService;

@RestController
@RequestMapping(path = "/api")
public class FormationRestApi {

	@Autowired
	private FormationService formationService;
	
	@GetMapping(path = "/formation/{id}")
	public FormationResponseDto getFormation(@PathVariable(name = "id") String formationId) {
		return formationService.getFormation(formationId);
	}
	
	@GetMapping(path = "/formation/{agentId}")
	public List<FormationResponseDto> getFormationsParAgent(@PathVariable String agentId) {
		return formationService.formationParAgentId(agentId);
	}
	
	@PostMapping(path = "/formations")
	public FormationResponseDto enregistrerFormation(@RequestBody FormationRequestDto formationRequestDto) {
		return formationService.save(formationRequestDto);
	}
}
