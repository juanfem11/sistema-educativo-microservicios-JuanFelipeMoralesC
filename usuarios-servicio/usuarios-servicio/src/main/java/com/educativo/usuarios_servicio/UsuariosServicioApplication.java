package com.educativo.usuarios_servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")

public class UsuariosServicioApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsuariosServicioApplication.class, args);
	}
}
