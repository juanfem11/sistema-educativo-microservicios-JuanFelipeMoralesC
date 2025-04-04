package com.educativo.matriculas_servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.educativo.matriculas_servicio.clientes")
public class MatriculasServicioApplication {
	public static void main(String[] args) {
		SpringApplication.run(MatriculasServicioApplication.class, args);
	}
}