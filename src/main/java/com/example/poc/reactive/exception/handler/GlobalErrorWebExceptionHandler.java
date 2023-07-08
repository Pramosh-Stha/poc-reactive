package com.example.poc.reactive.exception.handler;

import com.example.poc.reactive.utils.ResponseBodyWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author Pramosh Shrestha
 * @created 08/07/2023: 13:04
 */
@Component
@RequiredArgsConstructor
@Order(value = -2)
public class GlobalErrorWebExceptionHandler implements WebExceptionHandler {

    private final ObjectMapper objectMapper;

    @Override
    public @NotNull Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        try {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatusCode.valueOf(400));
            response.getHeaders()
                    .setContentType(MediaType.APPLICATION_JSON);

            return response.writeWith(
                    Flux.just(
                            response.bufferFactory()
                                    .wrap(
                                            objectMapper.writeValueAsString(
                                                            ResponseBodyWrapper.<Void>builder()
                                                                    .message(ex.getMessage())
                                                                    .errorStack(
                                                                            Arrays.stream(ex.getStackTrace())
                                                                                    .map(StackTraceElement::toString)
                                                                                    .limit(20)
                                                                                    .toList()
                                                                    )
                                                                    .errorMessage(ex.getLocalizedMessage())
                                                                    .build()
                                                    )
                                                    .getBytes(StandardCharsets.UTF_8)
                                    )
                    )
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
