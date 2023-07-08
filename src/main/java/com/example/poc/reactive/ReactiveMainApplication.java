package com.example.poc.reactive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;


@SpringBootApplication
@EnableWebFlux
@Slf4j
public class ReactiveMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMainApplication.class, args);
	}
}
