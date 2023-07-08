package com.example.poc.reactive.config.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import reactor.core.publisher.Mono;

/**
 * @author Pramosh Shrestha
 * @created 08/07/2023: 11:27
 */

@Configuration
public class ReactiveAuditAwareConfig {

    @Bean
    public ReactiveAuditorAware<String> reactiveAuditorAware() {
        return () -> Mono.just("Auditor's Name");
    }
}
