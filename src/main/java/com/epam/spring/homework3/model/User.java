package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private long userId;
    private String login;
    private String name;
    private String email;
    private String password;
    private Role role;
}