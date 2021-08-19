package fr.gouv.demo.micro.service.formationservice;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import fr.gouv.demo.micro.service.formationservice.dto.FormationRequestDto;
import fr.gouv.demo.micro.service.formationservice.service.FormationService;

@SpringBootApplication
@EnableFeignClients
public class FormationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormationServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(FormationService formationService) {
		return args -> {
			formationService.save(new FormationRequestDto(LocalDate.of(2021, 11, 10), true, "A01"));
			formationService.save(new FormationRequestDto(LocalDate.of(2021, 12, 9), false, "A01"));
			formationService.save(new FormationRequestDto(LocalDate.of(2021, 8, 23), true, "A02"));
		};
	}
	
}
