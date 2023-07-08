package com.example.poc.reactive.config;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Pramosh Shrestha
 * @created 06/07/2023: 10:26
 */
@Configuration
@RequiredArgsConstructor
public class FlywayConfig {

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        return new Flyway(
                Flyway.configure()
                        .dataSource(
                                "jdbc:postgresql://dev-restroverse.c234umvyutgq.us-east-1.rds.amazonaws.com:5432/postgres",
                                "ycore",
                                "Yantra#1209"
                        )
                        .baselineOnMigrate(true)
                        .defaultSchema("rdb")
                        .sqlMigrationSeparator("__")
                        .sqlMigrationSuffixes(".sql")
                        .locations("classpath:db/migration")
        );
    }
}
