package com.epam.spring.homework3.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private long userId;
    private String login;
    private String name;
    private String email;
}
