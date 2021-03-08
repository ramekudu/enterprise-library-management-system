package com.hsbc.libmansys.controller;


import com.hsbc.libmansys.dto.user.UserRequestDto;
import com.hsbc.libmansys.dto.user.UserResponseDto;
import com.hsbc.libmansys.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @InjectMocks
    private UserController  userController;

    @Mock
    private UserService userService;

    @Mock
    private UserRequestDto userRequestDto;

    @Test
    void get_user_returns_when_no_user_found(){
        ResponseEntity<UserResponseDto> response = userController.getUserById(UUID.randomUUID());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void create_user_returns_success(){
        given(userService.createUser(userRequestDto)).willReturn(new UserResponseDto());
        ResponseEntity<UserResponseDto> response = userController.createUser(userRequestDto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void get_user_returns_when_user_found(){
        UUID uuid = UUID.randomUUID();
        given(userService.findById(uuid)).willReturn(new UserResponseDto());
        ResponseEntity<UserResponseDto> response = userController.getUserById(uuid);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    @Test
    void update_user_returns_when_user_found(){
        UUID uuid = UUID.randomUUID();
        given(userService.updateUser(userRequestDto, uuid)).willReturn(new UserResponseDto());
        ResponseEntity<UserResponseDto> response = userController.updateUser(uuid,userRequestDto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
