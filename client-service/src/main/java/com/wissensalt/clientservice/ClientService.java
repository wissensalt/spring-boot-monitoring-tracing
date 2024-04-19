package com.wissensalt.clientservice;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@Slf4j
@RestController
@RequiredArgsConstructor
@SpringBootApplication
public class ClientService {

	private final RestClient restClient;
	public static void main(String[] args) {
		SpringApplication.run(ClientService.class, args);
	}

	record Employee(Long id, String email, String name) {}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> employees = restClient
				.get()
				.uri("/employees")
				.retrieve()
				.body(new ParameterizedTypeReference<>() {});

		log.info(">>> Retrieved Employees: {}", employees);

		return employees;
	}
}
