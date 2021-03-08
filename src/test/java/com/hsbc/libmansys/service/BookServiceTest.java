package com.hsbc.libmansys.service;

import com.hsbc.libmansys.dto.book.BookResponseDtoMapper;
import com.hsbc.libmansys.exception.BookNotFoundException;
import com.hsbc.libmansys.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository  bookRepository;

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookResponseDtoMapper bookResponseDtoMapper;


    @Test
    void fails_when_books_are_not_found(){
        given(bookRepository.findById(anyString())).willReturn(Optional.empty());
        assertThrows(BookNotFoundException.class, () -> bookService.findByIsbn(anyString()));
    }
}
