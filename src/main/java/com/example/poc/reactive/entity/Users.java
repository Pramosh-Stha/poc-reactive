package com.example.poc.reactive.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;


/**
 * @author Pramosh Shrestha
 * @created 03/07/2023: 17:33
 */

@Setter
@Getter
@Accessors(chain = true)
@Alias(value = "Users")
public class Users {

    @Id
    private Long id;

    @Column(value = "name")
    private String name;

    @Column(value = "city")
    private String city;

    @Column(value = "age")
    private Integer age;

    @Column(value = "salary")
    private Float salary;
}
