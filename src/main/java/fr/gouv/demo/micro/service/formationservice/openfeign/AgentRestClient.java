package fr.gouv.demo.micro.service.formationservice.openfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.gouv.demo.micro.service.formationservice.entities.Agent;

@FeignClient(name = "AGENT-SERVICE")
public interface AgentRestClient {

	@GetMapping(path = "/api/agent/{id}")
	Agent getAgent(@PathVariable(name = "id") String id);
	
	@GetMapping(path = "/api/agents")
	List<Agent> tousAgents();
	
}
