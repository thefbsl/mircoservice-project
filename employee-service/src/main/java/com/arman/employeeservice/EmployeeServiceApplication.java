package com.arman.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Arman",
						email = "armantastan135@gmail.com",
						url = "http://www.localhost:718"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.localhost:718/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot Appliance Service Documentation",
				url = "http://www.localhost:718/appliance.html"
		)
)
public class EmployeeServiceApplication {
	@Bean
	public ModelMapper mapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
