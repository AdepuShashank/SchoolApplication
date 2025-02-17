package com.shashank.SchoolApplication.services;

import com.shashank.SchoolApplication.Exceptionhandler.StudentNotFoundException;
import com.shashank.SchoolApplication.Repository.StudentRepository;
import com.shashank.SchoolApplication.models.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student getSingleStudentById(long id) throws StudentNotFoundException {
        Student student;
        Optional<Student> stu = studentRepository.findById(id);

        if(stu.isEmpty()){
            throw new StudentNotFoundException("no student found");
        }
        else {
            student = stu.get();
        }
        return student;
    }


}
