package com.hsbc.libmansys.controller;


import com.hsbc.libmansys.dto.book.BookRequestDto;
import com.hsbc.libmansys.dto.book.BookResponseDto;
import com.hsbc.libmansys.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@Validated
@RequestMapping(BookController.ENDPOINT)
@Api(tags = "Books")
public class BookController {

    public static final String ENDPOINT = "/books";

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService =bookService;
    }

    @PostMapping("/book")
    @ApiOperation(value = "Create a new record for a book")
    public ResponseEntity<BookResponseDto> createBook(
            @ApiParam(value = "book request")
            @Valid
            @RequestBody BookRequestDto bookRequestDto
    ) {
        BookResponseDto bookResponseDto = bookService.createBook(bookRequestDto);
        return ResponseEntity.status(CREATED).body(bookResponseDto);
    }


    @GetMapping("/book/{isbn}")
    @ApiOperation(value = "Get a book using its ISBN")
    public ResponseEntity<BookResponseDto> getBookByIsbn(
            @ApiParam(value = "ISBN Value", required = true)
            @PathVariable String isbn) {
         return  ResponseEntity.of(Optional.ofNullable(bookService.findByIsbn(isbn)));
    }



    @PutMapping("/book/{isbn}")
    @ApiOperation(value = "Update a book")
    public ResponseEntity<BookResponseDto> updateBook(@ApiParam(value = "ISBN Value", required = true) @PathVariable String isbn, @ApiParam(value = "book request") @RequestBody BookRequestDto bookRequestDto) {
        return  ResponseEntity.of(Optional.ofNullable(bookService.updateBook(bookRequestDto,isbn)));
    }

    @DeleteMapping( "/book/{isbn}")
    @ApiOperation(value = "Delete a book")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        return bookService.deleteBook(isbn);
    }



}
