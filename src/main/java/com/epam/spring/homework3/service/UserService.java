package com.epam.spring.homework3.service;

import com.epam.spring.homework3.controller.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(long userId, UserDTO userDTO);

    void deleteUser(long userId);

    UserDTO getUserById(long userId);
}