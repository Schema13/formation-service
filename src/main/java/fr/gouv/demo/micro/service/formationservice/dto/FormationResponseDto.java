package fr.gouv.demo.micro.service.formationservice.dto;

import java.time.LocalDate;

import fr.gouv.demo.micro.service.formationservice.entities.Agent;

public class FormationResponseDto {

	private String id;
	
	private LocalDate date;
	
	private boolean formationDemandee;
	
	private String agentId;

	private Agent agent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isFormationDemandee() {
		return formationDemandee;
	}

	public void setFormationDemandee(boolean formationDemandee) {
		this.formationDemandee = formationDemandee;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public FormationResponseDto(String id, LocalDate date, boolean formationDemandee, String agentId, Agent agent) {
		super();
		this.id = id;
		this.date = date;
		this.formationDemandee = formationDemandee;
		this.agentId = agentId;
		this.agent = agent;
	}

	public FormationResponseDto() {
		super();
	}
	
	
}
