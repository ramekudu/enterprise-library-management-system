package com.hsbc.libmansys.controller;

import com.hsbc.libmansys.dto.book.BookRequestDto;
import com.hsbc.libmansys.dto.book.BookResponseDto;
import com.hsbc.libmansys.service.BookService;
import com.hsbc.libmansys.service.BookServiceTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    @InjectMocks
    private BookController  bookController;

    @Mock
    private BookService bookService;

    @Mock
    private BookRequestDto  bookRequestDto;

    @Test
    void get_book_returns_when_no_book_found(){
        ResponseEntity<BookResponseDto> response = bookController.getBookByIsbn("random");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void create_book_returns_success(){
        given(bookService.createBook(bookRequestDto)).willReturn(new BookResponseDto());
        ResponseEntity<BookResponseDto> response = bookController.createBook(bookRequestDto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void get_book_returns_when_book_found(){
        given(bookService.findByIsbn(anyString())).willReturn(new BookResponseDto());
        ResponseEntity<BookResponseDto> response = bookController.getBookByIsbn(anyString());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    @Test
    void update_book_returns_when_book_found(){
        given(bookService.updateBook(bookRequestDto, "1111-1111")).willReturn(new BookResponseDto());
        ResponseEntity<BookResponseDto> response = bookController.updateBook("1111-1111",bookRequestDto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
