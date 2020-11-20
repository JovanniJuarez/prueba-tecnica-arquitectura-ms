package com.example.demo.prueba.tecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RepositoryDataH2Application {

	public static void main(String[] args) {
		SpringApplication.run(RepositoryDataH2Application.class, args);
	}

}
