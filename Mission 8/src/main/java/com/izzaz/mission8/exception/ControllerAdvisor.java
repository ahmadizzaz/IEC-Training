package com.izzaz.mission8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    //No results when searching specific game
    @ExceptionHandler(value = GameNotFoundException.class)
        public ResponseEntity<Object> handleGameNotFoundException(GameNotFoundException ex, WebRequest request){
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("message", "Game Not Found.");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }

    //No results when getting all games
    @ExceptionHandler(value = NoDataFoundException.class)
        public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException ex, WebRequest request){
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("message", "No game records found.");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }

    //ID parameter is either empty or duplicates with another existing id
    @ExceptionHandler(value = IdParamException.class)
    public ResponseEntity<Object> handleIdParamException(IdParamException ex, WebRequest request){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "The id parameter is either empty or duplicates with an existing record");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Name and platform is empty.
    @ExceptionHandler(value = EmptyParamException.class)
    public ResponseEntity<Object> handleEmptyParamException(EmptyParamException ex, WebRequest request){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "One or more parameter(s) are empty.");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
