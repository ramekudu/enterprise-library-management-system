package com.hsbc.libmansys.dto.book;

import com.hsbc.libmansys.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class BookRequestDtoMapper {
    public abstract Book toEntity(BookRequestDto bookRequestDto);
}
