package com.example.poc.reactive.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * The type Response body wrapper.
 *
 * @param <T> the type parameter
 */
@Setter
@Getter
@Accessors(chain = true)
@JsonPropertyOrder(value = {"payload", "message", "errorMessage", "errorStack"})
@Builder
public class ResponseBodyWrapper<T> {

    private T payload;

    private String message;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private List<String> errorStack;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String errorMessage;
}
