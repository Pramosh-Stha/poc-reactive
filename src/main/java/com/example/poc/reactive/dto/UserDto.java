package com.example.poc.reactive.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

/**
 * The type User dto.
 *
 * @author Pramosh Shrestha
 * @created 03 /07/2023: 17:31
 */
@Setter
@Getter
@Accessors(chain = true)
@Alias(value = "UserDto")
public class UserDto {

    private Long id;

    @NotNull(message = "not null field")
    @NotBlank(message = "not blank field")
    private String name;

    private String city;

    @Positive(message = "Positive number required")
    private Integer age;

    @PositiveOrZero(message = "Positive number required")
    private Float salary;

    private String createdBy;

    private String modifiedBy;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime createdOn;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime modifiedOn;

    private Boolean isDeleted;
}
