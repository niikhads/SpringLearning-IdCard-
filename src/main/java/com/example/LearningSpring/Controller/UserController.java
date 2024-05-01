package com.example.LearningSpring.Controller;


//import com.example.LearningSpring.Model.Dto.Request.LoginRequest;
import com.example.LearningSpring.Model.Dto.Request.LoginRequest;
import com.example.LearningSpring.Model.Dto.Request.RegisterRequest;
//import com.example.LearningSpring.Model.Dto.Response.LoginResponse;
import com.example.LearningSpring.Model.Dto.Response.LoginResponse;
import com.example.LearningSpring.Model.Dto.Response.RegisterResponse;
import com.example.LearningSpring.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse registerResponse = userService.register(registerRequest);
        return ResponseEntity.ok(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = userService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }
}
