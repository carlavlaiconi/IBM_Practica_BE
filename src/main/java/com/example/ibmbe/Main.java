package com.example.ibmbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.ibmbe")
@EnableJpaRepositories(basePackages = "com.example.ibmbe")
public class Main {
	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);
	}
}
