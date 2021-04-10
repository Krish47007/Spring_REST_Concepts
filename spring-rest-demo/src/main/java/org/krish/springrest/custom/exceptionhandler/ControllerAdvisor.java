package org.krish.springrest.custom.exceptionhandler;

import org.krish.springrest.custom.error.response.StudentErrorResponse;
import org.krish.springrest.custom.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    //Handles StudentNotFoundException
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e)
    {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());  //404
        error.setTimestamp(System.currentTimeMillis()); //current timestamp

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);    //Jackson will automatically convert StudentErrorResponse POJO and
        // convert to JSON.
    }

    //Generic exception handler for all exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e)
    {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.BAD_REQUEST);
    }
}
