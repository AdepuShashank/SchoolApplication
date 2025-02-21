package com.shashank.SchoolApplication.services;

import com.shashank.SchoolApplication.DTOs.StudentDTO;
import com.shashank.SchoolApplication.Repository.FacultyRepository;
import com.shashank.SchoolApplication.Repository.StudentRepository;
import com.shashank.SchoolApplication.models.Faculty;
import com.shashank.SchoolApplication.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StandardService {
    StudentRepository studentRepository;
    FacultyRepository facultyRepository;
    public StandardService(StudentRepository studentRepository,FacultyRepository  facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    public List<StudentDTO> getStudentsFromAStandard(int standard) {
        List<Student> student = studentRepository.findByStandard(standard);
        List<StudentDTO> studentDTOs = new ArrayList<>();
        for(Student s: student){
            StudentDTO sDTO = new StudentDTO();
            sDTO.setName(s.getName());
            sDTO.setEmail(s.getEmail());
            sDTO.setNumber(s.getNumber());
            sDTO.setStandard(s.getStandard());
            sDTO.setSection(s.getSection());
            studentDTOs.add(sDTO);
        }
        return studentDTOs;

    }

    public List<String> facultyAndStudents(int standard, String section) {
        Faculty fac = facultyRepository.findByStandardAndSection(standard,section);

        List<StudentDTO> sDTO = new ArrayList<>();
        List<Student> student =  studentRepository.findByStandardAndSection(standard,section);
        for(Student s : student){
            StudentDTO stDTO = new StudentDTO();
            stDTO.setName(s.getName());
            stDTO.setEmail(s.getEmail());
            stDTO.setNumber(s.getNumber());
            stDTO.setStandard(s.getStandard());
            stDTO.setSection(s.getSection());
            sDTO.add(stDTO);
        }
        List<String> FacultyAndStudent  = new ArrayList<>();
        FacultyAndStudent.add(String.valueOf(fac));
        List<String> allStudents =  sDTO.stream()
                .map(s -> s.toString()).collect(Collectors.toList());
        FacultyAndStudent.addAll(allStudents);

        return FacultyAndStudent;

    }
}
