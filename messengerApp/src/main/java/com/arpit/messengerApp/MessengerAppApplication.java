package com.arpit.messengerApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class MessengerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessengerAppApplication.class, args);
	}

}
