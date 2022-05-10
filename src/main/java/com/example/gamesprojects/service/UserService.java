package com.example.gamesprojects.service;

import com.example.gamesprojects.domain.User;
import com.example.gamesprojects.exception.UserNotFoundException;
import com.example.gamesprojects.respository.UserRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRespository userRespository;

    public List<User> getUser() {
        return userRespository.findAll();
    }

    public User getUser(final Long id) throws UserNotFoundException {
        return userRespository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User saveUser(final User user) {
        return userRespository.save(user);
    }

    public void deleteUser(final Long id) throws UserNotFoundException {
        try {
            userRespository.deleteById(id);
        } catch (Exception e) {
            throw new UserNotFoundException();
        }
    }

    public User createUser(User user) {
        return userRespository.save(user);
    }

    public void blockUser(Long userId) throws UserNotFoundException {
        User blockedUser = userRespository.findById(userId).orElseThrow(UserNotFoundException::new);
        blockedUser.setStatus(false);
        userRespository.save(blockedUser);
    }

}
