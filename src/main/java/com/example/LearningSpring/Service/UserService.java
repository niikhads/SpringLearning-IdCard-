package com.example.LearningSpring.Service;

import com.example.LearningSpring.Model.Dto.Request.LoginRequest;
import com.example.LearningSpring.Model.Dto.Request.RegisterRequest;
import com.example.LearningSpring.Model.Dto.response.LoginResponse;
import com.example.LearningSpring.Model.Dto.response.RegisterResponse;
import com.example.LearningSpring.Model.Entity.User;

import java.util.Optional;

public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);

    Optional<User> getByUsername(String username);
}
