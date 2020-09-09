package com.example.gameManagerapi;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameManagerApiApplication {
	
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("Brazil"));
	}

	public static void main(String[] args) {
		SpringApplication.run(GameManagerApiApplication.class, args);
	}

}
