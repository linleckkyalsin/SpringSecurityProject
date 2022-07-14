package com.reytech.awsimageupload.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private static final List<Student> students=Arrays.asList(
            new Student(1,"llks"),
            new Student(2,"sth"),
            new Student(3,"chaw")
    );
    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){

        return students.stream().filter(student -> studentId.equals(student.getStudentId())).findFirst().orElseThrow(()->new IllegalStateException("Student"+studentId+"does not exist"));
    };
}
