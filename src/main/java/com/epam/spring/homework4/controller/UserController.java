package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.dto.UserDTO;
import com.epam.spring.homework4.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user")
    @ApiOperation("Get all user")
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    @ApiOperation("Create user")
    public UserDTO createUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user/{id}")
    @ApiOperation("Update user")
    public UserDTO updateUser(@PathVariable long id, @RequestBody @Valid UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/{id}")
    @ApiOperation("Get user by id")
    public UserDTO getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/user/{id}")
    @ApiOperation("Delete user by id")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}