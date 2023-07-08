package com.example.poc.reactive.service.impl;

import com.example.poc.reactive.entity.Users;
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
    public Mono<Users> findUserById() {
        return null;
    }

    @Override
    public Mono<Users> saveUser(Users users) {
        return usersRepo.save(users);
    }

    @Override
    public Mono<Integer> deleteUser(Long id) {
        return null;
    }
}
