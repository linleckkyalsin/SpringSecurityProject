package com.reytech.awsimageupload.student;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    public List<Student> STUDENTS= Arrays.asList(
            new Student(1,"Jhon"),
            new Student(2,"Smith"),
            new Student(3,"Jane")

    );
    @GetMapping
    public List<Student> getStudents(){
        return STUDENTS;
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("Create");
        System.out.println(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println("Delete");
        System.out.println(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId,@RequestBody Student student){
        System.out.println("Update");
        System.out.println(String.format("%s %s",studentId,student));
    }
}
