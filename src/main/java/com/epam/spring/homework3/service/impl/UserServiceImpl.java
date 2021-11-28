package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.controller.dto.UserDTO;
import com.epam.spring.homework3.model.User;
import com.epam.spring.homework3.repository.UserRepository;
import com.epam.spring.homework3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUser() {
        log.info("getAllUser");
        return userRepository.getAllUser()
                .stream()
                .map(this::mapUserToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        log.info("create user {}", userDTO.getUserId());
        User user = mapUserDTOToUser(userDTO);
        user = userRepository.createUser(user);
        return mapUserToUserDTO(user);
    }

    @Override
    public UserDTO updateUser(long userId, UserDTO userDTO) {
        log.info("update user");
        User user = mapUserDTOToUser(userDTO);
        user = userRepository.updateUser(userId, user);
        return mapUserToUserDTO(user);
    }

    @Override
    public void deleteUser(long userId) {
        log.info("delete user");
        userRepository.deleteUser(userId);
    }

    @Override
    public UserDTO getUserById(long userId) {
        log.info("get user by id {}", userId);
        User user = userRepository.getUserById(userId);
        return mapUserToUserDTO(user);
    }

    private UserDTO mapUserToUserDTO(User user) {
        return UserDTO.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .name(user.getName())
                .login(user.getLogin())
                .build();
    }

    private User mapUserDTOToUser(UserDTO userDTO) {
        return User.builder()
                .userId(userDTO.getUserId())
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .login(userDTO.getLogin())
                .build();
    }
}