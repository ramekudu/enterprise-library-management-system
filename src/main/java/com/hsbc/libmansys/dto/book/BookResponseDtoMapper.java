package com.hsbc.libmansys.dto.book;

import com.hsbc.libmansys.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BookResponseDtoMapper {
    public abstract BookResponseDto  fromEntity(Book book);

}
