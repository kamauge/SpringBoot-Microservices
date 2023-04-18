package com.amg.springbootmicroservices;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API documentation",
				description = "Spring Boot REST API documentation",
				version = "v1.0",

				contact = @Contact(
						name = "Gerald Kamau",
						email = "kamaugerald2@gmail.com"
				),
				license = @License(
						name = "Apache 2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management documentation"

		)
)

public class SpringbootMicroservicesApplication {
	@Bean
	public ModelMapper modelMapper(){

		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicroservicesApplication.class, args);
	}

}
