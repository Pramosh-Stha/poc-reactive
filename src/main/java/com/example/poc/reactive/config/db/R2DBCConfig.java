package com.example.poc.reactive.config.db;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Duration;

/**
 * @author Pramosh Shrestha
 * @created 07/07/2023: 14:49
 */

@Configuration
public class R2DBCConfig {

    @Bean
    @Primary
    public ConnectionPool connectionPool() {
        ConnectionFactory connectionFactory = new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host("dev-restroverse.c234umvyutgq.us-east-1.rds.amazonaws.com")
                        .database("postgres")
                        .username("ycore")
                        .password("Yantra#1209")
                        .schema("rdb")
                        .port(5432)
                        .build()
        );

        ConnectionPoolConfiguration connectionPoolConfiguration = ConnectionPoolConfiguration.builder(connectionFactory)
                .maxIdleTime(Duration.ofMinutes(45))
                .initialSize(20)
                .maxSize(50)
                .build();

        return new ConnectionPool(connectionPoolConfiguration);
    }

    @Bean
    @Primary
    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }
}
