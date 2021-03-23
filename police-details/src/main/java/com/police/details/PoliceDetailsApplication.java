package com.police.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.police")
@EntityScan("com.police.entities")
@EnableJpaRepositories(basePackages = "com.police.repositories")
public class PoliceDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoliceDetailsApplication.class, args);
	}

}
