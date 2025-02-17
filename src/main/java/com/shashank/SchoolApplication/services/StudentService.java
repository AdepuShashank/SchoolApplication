package com.shashank.SchoolApplication.services;

import com.shashank.SchoolApplication.Exceptionhandler.StudentNotFoundException;
import com.shashank.SchoolApplication.Repository.StudentRepository;
import com.shashank.SchoolApplication.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Student> GetAllStudents() {

        List<Student> allstudents = studentRepository.findAll();

        return allstudents;
    }
    public Student SaveStudent(Student student) {
        Student stud = studentRepository.save(student);

        return stud;
    }
    public Student UpdateSingleStudent(long id,String name,String email,int standard,String section,String number) throws StudentNotFoundException
    {

        Optional<Student> stu = studentRepository.findById(id);
        if(stu.isEmpty()){
            throw new StudentNotFoundException("no student found");
        }
        else {
            Student UpdateStudent = stu.get();
            if (name != null) {
                UpdateStudent.setName(name);
            }
            if (email != null) {
                UpdateStudent.setEmail(email);
            }
            if (standard != 0) {
                UpdateStudent.setStandard(standard);
            }
            if (section!= null) {
                UpdateStudent.setSection(section);
            }
            if (number != null) {
                UpdateStudent.setNumber(number);
            }
            Student UpdatedStudent = studentRepository.save(UpdateStudent);
            return UpdatedStudent;
        }
    }
    public String DeleteSingleStudent(long id) throws StudentNotFoundException {
        Optional<Student> studentInDB = studentRepository.findById(id);
        if (studentInDB.isEmpty()) {
            throw new StudentNotFoundException("not found so cant be deleted");
        } else {
            studentRepository.deleteById(id);
        }
        return "Deleted student " + id;
    }
}
