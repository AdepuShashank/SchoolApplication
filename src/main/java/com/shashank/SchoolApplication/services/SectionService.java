package com.shashank.SchoolApplication.services;

import com.shashank.SchoolApplication.DTOs.StudentDTO;
import com.shashank.SchoolApplication.Repository.SectionRepository;
import com.shashank.SchoolApplication.Repository.StudentRepository;
import com.shashank.SchoolApplication.models.Section;
import com.shashank.SchoolApplication.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SectionService {


    StudentRepository studentRepository;
    SectionRepository sectionRepository;
    public SectionService(StudentRepository studentRepository,SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
        this.studentRepository = studentRepository;
    }

   public List<StudentDTO> getStudentsFromASection(String section){
       List<Student> student = studentRepository.findBySection(section);
       List<StudentDTO> allStudentsInThisSection = new ArrayList<>();
       for(Student s : student){
           StudentDTO sDTO = new StudentDTO();
           sDTO.setName(s.getName());
           sDTO.setEmail(s.getEmail());
           sDTO.setStandard(s.getStandard());
           sDTO.setSection(section);
           sDTO.setNumber(s.getNumber());

           allStudentsInThisSection.add(sDTO);
       }
       return allStudentsInThisSection;
   }

//   public List<Section> getSections(){
//        List<Section> section = sectionRepository.findAll();
//        List<Section> allsections = new ArrayList<>();
//        for(Section s : section){
//            Section sec = new Section();
//            sec.setSectionName(s.getSectionName());
//            allsections.add(sec);
//        }
//        return allsections;
//   }

}
