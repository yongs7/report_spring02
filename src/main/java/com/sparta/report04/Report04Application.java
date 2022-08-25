package com.sparta.report04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Report04Application {

	public static void main(String[] args) {
		SpringApplication.run(Report04Application.class, args);
	}

}
