package com.example.poc.reactive.service.impl;

import com.example.poc.reactive.entity.Users;
import com.example.poc.reactive.exception.EntityNotFoundException;
import com.example.poc.reactive.repo.UsersRepo;
import com.example.poc.reactive.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Pramosh Shrestha
 * @created 05/07/2023: 16:46
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {

    private final UsersRepo usersRepo;

    @Override
    public Flux<Users> findAllUser() {
        return usersRepo.findAll();
    }

    @Override
    public Mono<Users> findUserById(Long id) {
        return usersRepo.findById(id)
                .switchIfEmpty(Mono.error(new EntityNotFoundException("not.found")));
    }

    @Override
    public Mono<Users> saveUser(Mono<Users> users) {
        return users.flatMap(usersRepo::save);
    }

    @Override
    public Mono<Users> updateUser(Mono<Users> users, Long id) {
        return null;
    }

    @Override
    public Mono<Integer> deleteUser(Long id) {
        return null;
    }
}
