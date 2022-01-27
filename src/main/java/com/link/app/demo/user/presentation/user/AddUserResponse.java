package com.link.app.demo.user.presentation.user;

import lombok.Data;

@Data
public class AddUserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
