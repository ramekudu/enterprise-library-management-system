package com.hsbc.libmansys.dto.user;

import com.hsbc.libmansys.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserRequestDtoMapper {
    public abstract User toEntity(UserRequestDto userRequestDto);
}
