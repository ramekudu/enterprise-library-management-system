package com.hsbc.libmansys.service;

import com.hsbc.libmansys.dto.book.BookResponseDtoMapper;
import com.hsbc.libmansys.dto.user.UserResponseDtoMapper;
import com.hsbc.libmansys.exception.BookNotFoundException;
import com.hsbc.libmansys.exception.UserNotFoundException;
import com.hsbc.libmansys.repository.BookRepository;
import com.hsbc.libmansys.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Mock
    private UserResponseDtoMapper userResponseDtoMapper;


    @Test
    void fails_when_users_are_not_found(){
        UUID uuid = UUID.randomUUID();
        given(userRepository.findById(uuid)).willReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> userService.findById(uuid));
    }
}
