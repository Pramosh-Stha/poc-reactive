package com.example.poc.reactive.repo;

import com.example.poc.reactive.entity.Users;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

/**
 * @author Pramosh Shrestha
 * @created 05/07/2023: 16:53
 */
public interface UsersRepo extends R2dbcRepository<Users, Long> {
}
