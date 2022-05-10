package com.example.gamesprojects.controller;

import com.example.gamesprojects.domain.User;
import com.example.gamesprojects.domain.dto.UserDto;
import com.example.gamesprojects.exception.UserNotFoundException;
import com.example.gamesprojects.mapper.UserMapper;
import com.example.gamesprojects.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/users")
public class UserController {


    private final UserMapper userMapper;
    private final UserService userService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> usersDto = userMapper.mapToUserDtoList(userService.getUser());
        return ResponseEntity.ok(usersDto);
    }

    @GetMapping(value = "{usersId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long usersId) throws UserNotFoundException {
        UserDto userDto = userMapper.mapToUserDto(userService.getUser(usersId));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<UserDto> addUsers(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        return ResponseEntity.ok(userMapper.mapToUserDto(userService.createUser(user)));
    }

    @PutMapping(value = "block_user/{userId}")
    public ResponseEntity<Void> blockUser(@PathVariable Long userId) {
        userService.blockUser(userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws UserNotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}

