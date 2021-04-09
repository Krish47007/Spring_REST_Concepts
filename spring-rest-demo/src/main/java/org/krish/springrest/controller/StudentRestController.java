package org.krish.springrest.controller;

import org.krish.springrest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return sList.get(sid - 1);  //sList is 0 based.
    }
}
