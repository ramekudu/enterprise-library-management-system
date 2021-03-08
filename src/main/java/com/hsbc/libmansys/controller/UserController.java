package com.hsbc.libmansys.controller;


import com.hsbc.libmansys.dto.user.UserRequestDto;
import com.hsbc.libmansys.dto.user.UserResponseDto;
import com.hsbc.libmansys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@Validated
@RequestMapping(UserController.ENDPOINT)
@Api(tags = "Users")
public class UserController {

    public static final String ENDPOINT = "/users";

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService =userService;
    }

    @PostMapping("/user")
    @ApiOperation(value = "Create a new record for a user")
    public ResponseEntity<UserResponseDto> createUser(
            @ApiParam(value = "user request")
            @Valid
            @RequestBody UserRequestDto userRequestDto
    ) {
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return ResponseEntity.status(CREATED).body(userResponseDto);
    }


    @GetMapping("/user/{id}")
    @ApiOperation(value = "Get a user using its id")
    public ResponseEntity<UserResponseDto> getUserById(
            @ApiParam(value = "id", required = true)
            @PathVariable UUID id) {
        return  ResponseEntity.of(Optional.ofNullable(userService.findById(id)));
    }



    @PutMapping("/user/{id}")
    @ApiOperation(value = "Update a user")
    public ResponseEntity<UserResponseDto> updateUser(@ApiParam(value = "id", required = true) @PathVariable UUID id, @ApiParam(value = "user request") @RequestBody UserRequestDto userRequestDto) {
        return  ResponseEntity.of(Optional.ofNullable(userService.updateUser(userRequestDto,id)));
    }

    @DeleteMapping( "/user/{id}")
    @ApiOperation(value = "Delete a user")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        return userService.deleteUser(id);
    }



}
