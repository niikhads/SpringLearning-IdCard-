package com.example.LearningSpring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;


@Getter
@AllArgsConstructor
public class CommonExpection extends RuntimeException{

    private String code;
    private String description;
    private HttpStatusCode httpStatusCode;
}
