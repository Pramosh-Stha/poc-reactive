package com.example.poc.reactive.service;

import com.example.poc.reactive.entity.Users;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author Pramosh Shrestha
 * @created 05/07/2023: 16:45
 */
public interface UsersService {

    Flux<Users> findAllUser();

    Mono<Users> findUserById();

    Mono<Users> saveUser(Users users);

    Mono<Integer> deleteUser(Long id);
}
