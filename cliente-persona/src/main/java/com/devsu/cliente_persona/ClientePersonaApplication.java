package com.devsu.cliente_persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.devsu.cliente_persona", "com.devsu.commons"})
public class ClientePersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientePersonaApplication.class, args);
	}

}
