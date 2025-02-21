package com.shashank.SchoolApplication.Controllers;

import com.shashank.SchoolApplication.DTOs.StudentDTO;
import com.shashank.SchoolApplication.services.StandardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class StandardController {
    StandardService standardService;

    public StandardController(StandardService standardService){
        this.standardService = standardService;
    }

    @GetMapping("allstudentsfromastandard/{standard}")
    public List<StudentDTO> getAllStudentsInAStandard(@PathVariable("standard") int standard){
        List<StudentDTO> allStudents = standardService.getStudentsFromAStandard(standard);
        return allStudents;
    }
    @GetMapping("FAndSfrom/{standard}/{section}")
    public List<String>  FAndSfrom(@PathVariable("standard") int standard,@PathVariable String section){
        List<String> FAndS = standardService.facultyAndStudents(standard,section);
        return FAndS;
    }
}
