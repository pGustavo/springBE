package com.app.sorteios.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class SorteiosApiApplication {

	@CrossOrigin
	public static void main(String[] args) {
		SpringApplication.run(SorteiosApiApplication.class, args);
	}

}
