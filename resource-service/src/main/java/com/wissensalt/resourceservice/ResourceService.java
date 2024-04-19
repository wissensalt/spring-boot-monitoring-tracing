package com.wissensalt.resourceservice;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class ResourceService {

	public static void main(String[] args) {
		SpringApplication.run(ResourceService.class, args);
	}

	record Employee(Long id, String email, String name) {}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		log.info("Returning Employee");

		return List.of(
				new Employee(1L, "david@mail.com", "David"),
				new Employee(2L, "john@mail.com", "John"));
	}
}
