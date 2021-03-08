package com.hsbc.libmansys.service;

import com.hsbc.libmansys.dto.book.BookRequestDto;
import com.hsbc.libmansys.dto.book.BookRequestDtoMapper;
import com.hsbc.libmansys.dto.book.BookResponseDto;
import com.hsbc.libmansys.dto.book.BookResponseDtoMapper;
import com.hsbc.libmansys.entity.Book;
import com.hsbc.libmansys.exception.BookNotFoundException;
import com.hsbc.libmansys.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookRequestDtoMapper  bookRequestDtoMapper;
    private final BookResponseDtoMapper  bookResponseDtoMapper;


    @Autowired
    public BookService(BookRepository bookRepository,
                       BookRequestDtoMapper bookRequestDtoMapper,
                       BookResponseDtoMapper bookResponseDtoMapper) {
        this.bookRepository = bookRepository;
        this.bookRequestDtoMapper = bookRequestDtoMapper;
        this.bookResponseDtoMapper = bookResponseDtoMapper;
    }

    public BookResponseDto createBook(BookRequestDto bookRequestDto) {
        Book book =  bookRequestDtoMapper.toEntity(bookRequestDto);
        Book createdBook = bookRepository.save(book);
        return bookResponseDtoMapper.fromEntity(createdBook);

    }

    public BookResponseDto findByIsbn(String isbn) {
        Optional<Book> foundBook = bookRepository.findById(isbn);
        return foundBook.map(bookResponseDtoMapper::fromEntity).orElseThrow(() -> new BookNotFoundException(isbn));
    }



    public BookResponseDto updateBook(BookRequestDto bookRequestDto,String isbn) {
        Optional<Book> foundBook = bookRepository.findById(isbn);
        Book updatedBookInstance;
        if(foundBook.isPresent()) {
            Book book = bookRequestDtoMapper.toEntity(bookRequestDto);
            updatedBookInstance = bookRepository.save(book);
        }
        else throw new BookNotFoundException(isbn);

        return bookResponseDtoMapper.fromEntity(updatedBookInstance);
    }

    public ResponseEntity<Void> deleteBook(String isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        if(book.isPresent()) {
            bookRepository.delete(book.get());
        }
        return null;
    }


}
