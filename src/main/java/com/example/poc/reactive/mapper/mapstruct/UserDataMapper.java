package com.example.poc.reactive.mapper.mapstruct;

import com.example.poc.reactive.dto.UserDto;
import com.example.poc.reactive.entity.Users;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author Pramosh Shrestha
 * @created 06/07/2023: 08:01
 */

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UserDataMapper {

    UserDto toDto(Users users);

    Users toEntity(UserDto userDto);
}
