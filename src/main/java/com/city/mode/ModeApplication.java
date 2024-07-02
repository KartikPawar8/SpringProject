package com.city.mode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.city.mode")
public class ModeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModeApplication.class, args);
	}

}
