package com.example.LearningSpring.exception.handler;


import com.example.LearningSpring.exception.CommonExpection;
import com.example.LearningSpring.exception.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CommonExpection.class)
    public ResponseEntity<ErrorDetails> handleUserNotExistException (CommonExpection exception){
       ErrorDetails errorDetails =  new  ErrorDetails(exception.getCode() , exception.getDescription());
        return ResponseEntity.
                status(exception.getHttpStatusCode())
                .body(errorDetails);
    }


//    @ExceptionHandler (UserNotExistException.class)
//    public ResponseEntity<ErrorDetails> handleUserNotExistException (UserNotExistException exception){
//       ErrorDetails errorDetails =  new  ErrorDetails("1000" , "user  not exist in db");
//        return ResponseEntity.
//                status(HttpStatus.BAD_REQUEST)
//                .body(errorDetails);
//    }
//    @ExceptionHandler (PasswordNotMatchedException.class)
//    public ResponseEntity<ErrorDetails> handleUserPasswordNotMatched (PasswordNotMatchedException exception){
//        ErrorDetails errorDetails =  new  ErrorDetails("1001" , "Password and confirm password not matched");
//        return ResponseEntity.
//                status(HttpStatus.BAD_REQUEST)
//                .body(errorDetails);
//    }

}
