package com.example.poc.reactive.controller;

import com.example.poc.reactive.dto.UserDto;
import com.example.poc.reactive.mapper.mapstruct.UserDataMapper;
import com.example.poc.reactive.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Pramosh Shrestha
 * @created 03/07/2023: 17:25
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UsersController {

    private final UserDataMapper userDataMapper;

    private final UsersService usersService;

    @GetMapping
    public Flux<UserDto> getAllUsers() {
        return usersService.findAllUser()
                .map(userDataMapper::toDto);
    }

    @GetMapping(value = "/{id}")
    public Mono<UserDto> getUserById(@PathVariable(value = "id") final Long id) {
        return usersService.findUserById(id)
                .map(userDataMapper::toDto);
    }

    @PostMapping
    public Mono<UserDto> saveAnUser(@RequestBody @Valid Mono<UserDto> userDto) {
        return usersService.saveUser(userDto.map(userDataMapper::toEntity))
                .map(userDataMapper::toDto);
    }

    @PutMapping(value = "/{id}")
    public Mono<UserDto> updateAnUser(
            @PathVariable(value = "id") final Long id,
            @RequestBody @Valid Mono<UserDto> userDto
    ) {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Integer> deleteAnUser(@PathVariable(value = "id") final Long id) {
        return null;
    }
}
