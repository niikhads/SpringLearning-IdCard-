package com.example.LearningSpring.exception;

public record ErrorDetails (String code , String description) {

    public static ErrorDetails of(String code , String description)  {
        return   new ErrorDetails (code,description);
    }
}
