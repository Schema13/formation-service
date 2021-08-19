package fr.gouv.demo.micro.service.formationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gouv.demo.micro.service.formationservice.entities.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, String>{

	List<Formation> findByAgentId(String agentId);
}
