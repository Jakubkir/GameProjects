package com.example.gamesprojects.controller;

import com.example.gamesprojects.exception.CollectionNotFoundException;
import com.example.gamesprojects.exception.GameNotFoundException;
import com.example.gamesprojects.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class HttpError extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(GameNotFoundException exception) {
        return new ResponseEntity<>("Book with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CollectionNotFoundException.class)
    public ResponseEntity<Object> handleCollectionNotFoundException(CollectionNotFoundException exception) {
        return new ResponseEntity<>("Collection with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
        return new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
