package com.hsbc.libmansys.service;

import com.hsbc.libmansys.dto.user.UserRequestDto;
import com.hsbc.libmansys.dto.user.UserRequestDtoMapper;
import com.hsbc.libmansys.dto.user.UserResponseDto;
import com.hsbc.libmansys.dto.user.UserResponseDtoMapper;
import com.hsbc.libmansys.entity.User;
import com.hsbc.libmansys.exception.UserNotFoundException;
import com.hsbc.libmansys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRequestDtoMapper userRequestDtoMapper;
    private final UserResponseDtoMapper userResponseDtoMapper;


    @Autowired
    public UserService(UserRepository userRepository,
                       UserRequestDtoMapper userRequestDtoMapper,
                       UserResponseDtoMapper userResponseDtoMapper) {
        this.userRepository = userRepository;
        this.userRequestDtoMapper = userRequestDtoMapper;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user =  userRequestDtoMapper.toEntity(userRequestDto);
        User createdUser = userRepository.save(user);
        return userResponseDtoMapper.fromEntity(createdUser);

    }

    public UserResponseDto findById(UUID id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.map(userResponseDtoMapper::fromEntity).orElseThrow(() -> new UserNotFoundException(id));
    }



    public UserResponseDto updateUser(UserRequestDto userRequestDto,UUID id) {
        Optional<User> foundUser = userRepository.findById(id);
        User updatedUserInstance;
        if(foundUser.isPresent()) {
            User user = userRequestDtoMapper.toEntity(userRequestDto);
            updatedUserInstance = userRepository.save(user);
        }
        else throw new UserNotFoundException(id);

        return userResponseDtoMapper.fromEntity(updatedUserInstance);
    }

    public ResponseEntity<Void> deleteUser(UUID isbn) {
        Optional<User> user = userRepository.findById(isbn);
        if(user.isPresent()) {
            userRepository.delete(user.get());
        }
        return null;
    }


}

