package com.app.exes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@SpringBootApplication
public class ExesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExesApplication.class, args);
	}
}
