package com.app.sorteios.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class SorteiosApiApplication {
	// to build
	// cd C:\Users\gusta\WebstormProjects\app.sorteios
	// .\mvnw clean install

	@CrossOrigin
	public static void main(String[] args) {
		SpringApplication.run(SorteiosApiApplication.class, args);
	}

}
