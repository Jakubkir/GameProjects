package com.example.gamesprojects.mapper;

import com.example.gamesprojects.domain.User;
import com.example.gamesprojects.domain.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
        userDto.getId(),
        userDto.getLogin(),
        userDto.getEmail(),
        userDto.getPassword(),
        userDto.getAddress()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getLogin(),
                user.getEmail(),
                user.getPassword(),
                user.getAddress()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
