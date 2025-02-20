package com.shashank.SchoolApplication.services;


import com.shashank.SchoolApplication.DTOs.StudentDTO;
import com.shashank.SchoolApplication.Exceptionhandler.StudentNotFoundException;
import com.shashank.SchoolApplication.Mappers.StudentMapper;
import com.shashank.SchoolApplication.Repository.StudentRepository;
import com.shashank.SchoolApplication.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;
    StudentMapper studentMapper;
    public StudentService(StudentRepository studentRepository,StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
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

    public List<StudentDTO> GetAllStudents() {
        List<Student> students = studentRepository.findAll();

        List<StudentDTO> allstudents = new ArrayList<>();

        for(Student s : students){
            StudentDTO sDTO = new StudentDTO();

            sDTO.setName(s.getName());
            sDTO.setEmail(s.getEmail());
            sDTO.setNumber(s.getNumber());
            sDTO.setSection(s.getSection());
            sDTO.setStandard(s.getStandard());

            allstudents.add(sDTO);
        }

        return allstudents;
    }

    public Student SaveStudent(String name, String email, int standard, String section, String number) {
        Student stu = new Student();
        stu.setName(name);
        stu.setEmail(email);
        stu.setNumber(number);
        stu.setStandard(standard);
        stu.setSection(section);


        Student stud = studentRepository.save(stu);

        return stud;
    }

    public Student UpdateSingleStudent(long id, String name, String email, int standard, String section, String number) throws StudentNotFoundException
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
