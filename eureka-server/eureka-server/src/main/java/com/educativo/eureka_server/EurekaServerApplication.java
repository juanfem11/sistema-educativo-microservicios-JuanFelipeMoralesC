package com.educativo.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
	public static void main(String[] args) {

		System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "default");

		SpringApplication.run(EurekaServerApplication.class, args);

		System.out.println("Eureka Server iniciado correctamente en http://localhost:8761");
	}
}
