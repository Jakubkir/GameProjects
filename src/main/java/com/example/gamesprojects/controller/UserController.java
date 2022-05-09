package com.example.gamesprojects.controller;

import com.example.gamesprojects.domain.dto.UserDto;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/users")
public class UserController {


    private final UserMapper userMapper;
    private final UserService userDbService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userDbService = userDbService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> usersDto = userMapper.mapToUserDtoList(userDbService.getUsers());
        return ResponseEntity.ok(usersDto);
    }

    @GetMapping(value = "{usersId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long usersId) {
        UserDto userDto = userMapper.mapToUserDto(userDbService.getUser(usersId));
        return ResponseEntity.ok(usersDto);
    }

    @PostMapping
    public ResponseEntity<UserDto> addUsers(@RequestBody UserDto usersDto) {
        User user = userMapper.mapToUser(usersDto);
        return ResponseEntity.ok(userMapper.mapToUserDto(userDbService.createUser(user)));
    }

    @PutMapping(value = "block_user/{userId}")
    public ResponseEntity<Void> blockUser(@PathVariable Long userId) {
        userDbService.blockUser(userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws UserNotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}

