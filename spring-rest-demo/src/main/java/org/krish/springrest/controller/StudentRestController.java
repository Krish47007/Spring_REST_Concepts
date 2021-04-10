package org.krish.springrest.controller;

import org.krish.springrest.custom.error.response.StudentErrorResponse;
import org.krish.springrest.custom.exception.StudentNotFoundException;
import org.krish.springrest.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> sList;

    @PostConstruct
    public void loadStudents()
    {
        sList = new ArrayList<>();

        sList.add(new Student("Kirk","James T."));
        sList.add(new Student("Picard","Jean-Luc"));
        sList.add(new Student("Benjamin","Cisko"));
        sList.add(new Student("Johnathan","Archer"));
    }

    @GetMapping("/students")
    public List<Student> getStudents()  //Jackson will convert the List<Students> to JSON array
    {
        return sList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") int sid)
    {
        if(sid <= 0 || sid > sList.size())
            throw new StudentNotFoundException("Student with id "+sid+" doesn't exist");

        return sList.get(sid - 1);  //sList is 0 based.
    }

    //Add an exception handler using @ExceptionHandler

    /*
     *
     * @ExceptionHandler - tells Spring that this method is an exception handler.
     * ResponseEntity<StudentErrorResponse> - type of the response body.
     * StudentNotFoundException -   is the exception type to catch
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e)
    {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());  //404
        error.setTimestamp(System.currentTimeMillis()); //current timestamp

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);    //Jackson will automatically convert StudentErrorResponse POJO and
                                                                    // convert to JSON.
    }
}
