package com.devsu.cuenta_movimientos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.devsu.cuenta_movimientos", "com.devsu.commons"})
public class CuentaMovimientosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuentaMovimientosApplication.class, args);
	}

}
