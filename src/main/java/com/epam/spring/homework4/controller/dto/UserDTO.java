package com.epam.spring.homework4.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class UserDTO {
    private long userId;
    @NotBlank
    private String login;
    @NotBlank
    private String name;
    @Email
    private String email;
}
