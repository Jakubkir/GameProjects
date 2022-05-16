package com.example.gamesprojects.service;

import com.example.gamesprojects.domain.User;
import com.example.gamesprojects.exception.UserNotFoundException;
import com.example.gamesprojects.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User getUser(final Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }


    public void deleteUser(final Long id) throws UserNotFoundException {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new UserNotFoundException();
        }
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void blockUser(Long userId) throws UserNotFoundException {
        User blockedUser = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        blockedUser.setStatus(false);
        userRepository.save(blockedUser);
    }

}
