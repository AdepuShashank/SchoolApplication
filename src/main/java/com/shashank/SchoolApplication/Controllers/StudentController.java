package com.shashank.SchoolApplication.Controllers;

import com.shashank.SchoolApplication.models.Student;
import com.shashank.SchoolApplication.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/student")
    public List<Student> getAllStudents(){
        List<Student> students = studentService.GetAllStudents();
        return students;
    }
    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        Student stud = studentService.SaveStudent(student);
        return stud;
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable("id") Long id,
                                 @RequestBody Student student) {

        Student updateStudent = studentService.UpdateSingleStudent(id,
                student.getName(),
                student.getEmail(),
                student.getStandard(),
                student.getSection(),
                student.getNumber());
        return updateStudent;
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable("id") long id) {


        return studentService.DeleteSingleStudent(id);
    }
}
