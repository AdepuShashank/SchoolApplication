package com.shashank.SchoolApplication.Mappers;

import com.shashank.SchoolApplication.DTOs.StudentDTO;
import com.shashank.SchoolApplication.models.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDTO toStudentDTO(String name, String email, int standard, String section, String number) {
        StudentDTO dto = new StudentDTO();

        dto.setName(name);
        dto.setEmail(email);
        dto.setStandard(standard);
        dto.setSection(section);
        dto.setNumber(number);
        return dto;
    }
    public Student toStudent(String name, String email, int standard, String section, String number) {
        Student student = new Student();
        student.setName(name);

        student.setEmail(email);
        student.setStandard(standard);
        student.setSection(section);
        student.setNumber(number);
        return student;
    }
}
