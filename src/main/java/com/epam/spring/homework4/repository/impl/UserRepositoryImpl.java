package com.epam.spring.homework4.repository.impl;

import com.epam.spring.homework4.model.User;
import com.epam.spring.homework4.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final List<User> userList = new ArrayList<>();
    private long id = 1;

    @Override
    public List<User> getAllUser() {
        return new ArrayList<>(userList);
    }

    @Override
    public User createUser(User user) {
        user.setUserId(id++);
        userList.add(user);
        return user;
    }

    @Override
    public User getUserById(long userId) {
        return userList.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not found!"));
    }

    @Override
    public User updateUser(long userId, User user) {
        boolean isDeleted = userList.removeIf(u -> u.getUserId() == userId);
        if (isDeleted) {
            user.setUserId(userId);
            userList.add(user);
        } else {
            throw new RuntimeException("User is not found!");
        }
        return user;
    }

    @Override
    public void deleteUser(long userId) {
        userList.remove(getUserById(userId));
    }
}