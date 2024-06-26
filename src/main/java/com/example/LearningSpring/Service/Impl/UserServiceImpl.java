package com.example.LearningSpring.Service.Impl;

import com.example.LearningSpring.Mapper.UserMapper;
import com.example.LearningSpring.Util.JwtProvider;
import com.example.LearningSpring.Model.Dto.Request.LoginRequest;
import com.example.LearningSpring.Model.Dto.Request.RegisterRequest;
import com.example.LearningSpring.Model.Dto.response.LoginResponse;
import com.example.LearningSpring.Model.Dto.response.RegisterResponse;
import com.example.LearningSpring.Model.Entity.User;
import com.example.LearningSpring.Repository.mapper.UserMyBatisRepository;
import com.example.LearningSpring.Service.UserService;
import com.example.LearningSpring.exception.CommonExpection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private  final UserMyBatisRepository userRepository;
    private final UserMapper userMapper;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager; // error
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> userOptional = getByUsername(loginRequest.getUsername());
        if (userOptional.isEmpty()) {
           // throw new UserNotExistException ("user not exist");
           // return LoginResponse.withResponse("user is not exist");
            throw new CommonExpection("1000", "user is not exist",HttpStatus.BAD_REQUEST);
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        authenticationManager.authenticate(authenticationToken);   // error


        String token = jwtProvider.generateToken(userOptional.get());

        return LoginResponse.withToken(token);
    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest){
 // 2 usulla yaza bilerik
//        registerRequest.getPassword().equals(registerRequest.getConfirmPassword())
//     null.equals(registerRequest.getConfirmPassword()) ---> NullPointerException

    if(!Objects.equals(registerRequest.getPassword(),registerRequest.getConfirmPassword())){
       // return new RegisterResponse("Password not matched");
       // throw new PasswordNotMatchedException ("password and confirmPassword not matched");
     throw new CommonExpection("1001", "Password and confirmPassword not matched",HttpStatus.BAD_REQUEST);
    }
    Optional<User> byUsernameOptional = userRepository.findByUsername(registerRequest.getUsername());
        if (byUsernameOptional.isPresent()){
            throw new CommonExpection("1002", "This username is dublicated username.Please check other username." ,HttpStatus.BAD_REQUEST);
       // return new RegisterResponse("This username is dublicated username.Please check other username.");
    }

    User user = userMapper.toUser(registerRequest);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));


    userRepository.insert(user);
    return new RegisterResponse("Success process");
    }

//    @Override  sorus
//    public Optional<User> getByUsername(String username) {
//        return Optional.empty();
//    }
      @Override
       public Optional<User> getByUsername(String username) {
           return userRepository.findByUsername(username);
       }

}
