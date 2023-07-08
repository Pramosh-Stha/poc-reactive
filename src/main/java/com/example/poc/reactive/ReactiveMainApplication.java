package com.example.poc.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.reactive.config.EnableWebFlux;


@SpringBootApplication
@EnableWebFlux
@EnableR2dbcAuditing(auditorAwareRef = "reactiveAuditorAware", modifyOnCreate = false)
@EnableR2dbcRepositories(basePackages = {"com.example.poc.reactive.repo"})
@EnableTransactionManagement
public class ReactiveMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveMainApplication.class, args);
    }
}
