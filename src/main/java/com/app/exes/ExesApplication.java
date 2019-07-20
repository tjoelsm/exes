package com.app.exes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication//(scanBasePackages = {"com.app.exes.repositories"})
public class ExesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExesApplication.class, args);
	}
}
