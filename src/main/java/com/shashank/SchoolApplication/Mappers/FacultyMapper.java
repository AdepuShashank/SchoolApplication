package com.shashank.SchoolApplication.Mappers;

import com.shashank.SchoolApplication.DTOs.FacultyDTO;
import com.shashank.SchoolApplication.models.Faculty;
import org.springframework.stereotype.Component;

@Component
public class FacultyMapper {

    public FacultyDTO toFacultyDTO(Faculty faculty){
        FacultyDTO fDTO = new FacultyDTO();
        fDTO.setFaculty_id(faculty.getId());
        fDTO.setName(faculty.getName());
        fDTO.setEmail(faculty.getEmail());
        fDTO.setSection(faculty.getSection());
        fDTO.setNumber(faculty.getNumber());

        return fDTO;
    }

    public Faculty toFaculty(FacultyDTO fDTO){
        Faculty f = new Faculty();
        f.setId(fDTO.getFaculty_id());
        f.setName(fDTO.getName());
        f.setEmail(fDTO.getEmail());
        f.setSection(fDTO.getSection());
        f.setNumber(fDTO.getNumber());
        return f;
    }
}
