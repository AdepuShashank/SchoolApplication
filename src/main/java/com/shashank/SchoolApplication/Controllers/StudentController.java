package com.shashank.SchoolApplication.Controllers;

import com.shashank.SchoolApplication.models.Student;
import com.shashank.SchoolApplication.services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/student/{id}")
    public Student getSingleStudentById(@PathVariable("id") long id){
        Student stu = studentService.getSingleStudentById(id);
        return stu;
    }
}
