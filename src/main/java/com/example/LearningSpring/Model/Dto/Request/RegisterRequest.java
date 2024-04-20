package com.example.LearningSpring.Model.Dto.Request;

import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String password;
    private String name;
    private String surname;
}
