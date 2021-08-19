package fr.gouv.demo.micro.service.formationservice.dto;

import java.time.LocalDate;

public class FormationRequestDto {
	
	private LocalDate date;
	
	private boolean formationDemandee;
	
	private String agentId;

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

	public FormationRequestDto(LocalDate date, boolean formationDemandee, String agentId) {
		super();
		this.date = date;
		this.formationDemandee = formationDemandee;
		this.agentId = agentId;
	}

	public FormationRequestDto() {
		super();
	}

	
}
