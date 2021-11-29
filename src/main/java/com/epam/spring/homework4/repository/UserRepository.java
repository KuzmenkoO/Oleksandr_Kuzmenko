package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUser();

    User createUser(User user);

    User getUserById(long userId);

    User updateUser(long userId, User user);

    void deleteUser(long userId);
}