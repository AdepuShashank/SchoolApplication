package com.shashank.SchoolApplication.Mappers;

import com.shashank.SchoolApplication.DTOs.StudentDTO;
import com.shashank.SchoolApplication.models.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDTO toStudentDTO(Student student) {
        StudentDTO dto = new StudentDTO();

        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setStandard(student.getStandard());
        dto.setSection(student.getSection());
        dto.setNumber(student.getNumber());
        return dto;
    }
    public Student toStudent(StudentDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());

        student.setEmail(dto.getEmail());
        student.setStandard(dto.getStandard());
        student.setSection(dto.getSection());
        student.setNumber(dto.getNumber());
        return student;
    }
}
