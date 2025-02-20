package com.shashank.SchoolApplication.Controllers;

import com.shashank.SchoolApplication.DTOs.StudentDTO;
import com.shashank.SchoolApplication.Mappers.StudentMapper;
import com.shashank.SchoolApplication.models.Student;
import com.shashank.SchoolApplication.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    StudentService studentService;
    StudentMapper studentMapper;

    public StudentController(StudentService studentService,StudentMapper studentMapper ){
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping("/student/{id}")
    public StudentDTO getSingleStudentById(@PathVariable("id") long id){
        Student stu = studentService.getSingleStudentById(id);
        Student StFDb = new Student();
        StFDb.setName(stu.getName());
        StFDb.setEmail(stu.getEmail());
        StFDb.setStandard(stu.getStandard());
        StFDb.setSection(stu.getSection());
        StFDb.setNumber(stu.getNumber());
        StudentDTO mappedstu = studentMapper.toStudentDTO(StFDb.getName(), StFDb.getEmail() ,StFDb.getStandard(), StFDb.getSection(), StFDb.getNumber());
        return mappedstu;
    }

    @GetMapping("/student")
    public List<StudentDTO> getAllStudents(){
        List<StudentDTO> students = studentService.GetAllStudents();



        return students;
    }

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        Student stud = studentService.SaveStudent(student.getName(),
                student.getEmail(),
                student.getStandard(),
                student.getSection(),
                student.getNumber());
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
