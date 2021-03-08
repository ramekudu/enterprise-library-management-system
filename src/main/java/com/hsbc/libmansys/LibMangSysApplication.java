package com.hsbc.libmansys;

import com.hsbc.libmansys.dto.book.BookRequestDto;
import com.hsbc.libmansys.dto.user.UserRequestDto;
import com.hsbc.libmansys.entity.Book;
import com.hsbc.libmansys.entity.User;
import com.hsbc.libmansys.repository.BookRepository;
import com.hsbc.libmansys.repository.UserRepository;
import com.hsbc.libmansys.service.BookService;
import com.hsbc.libmansys.service.UserService;
import org.jeasy.random.EasyRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class LibMangSysApplication
{
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;


    public static void main( String[] args ){
        SpringApplication.run(LibMangSysApplication.class, args);

    }

    @PostConstruct
    public void initApplication() throws IOException {
        EasyRandom easyRandom = new EasyRandom();
        int count=0;
        while(count < 10) {
            bookService.createBook(easyRandom.nextObject(BookRequestDto.class));
            userService.createUser(easyRandom.nextObject(UserRequestDto.class));
            count++;
        }

        
        
    }
}

