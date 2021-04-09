package org.krish.springrest.controller;

import org.krish.springrest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents()  //Jackson will convert the List<Students> to JSON array
    {
        return Arrays.asList(
                new Student("Kirk","James T."),
                new Student("Picard","Jean-Luc")
        );
    }
}
