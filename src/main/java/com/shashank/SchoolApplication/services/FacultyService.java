package com.shashank.SchoolApplication.services;

import com.shashank.SchoolApplication.Exceptionhandler.FacultyNotFoundException;
import com.shashank.SchoolApplication.Repository.FacultyRepository;
import com.shashank.SchoolApplication.models.Faculty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacultyService {

    FacultyRepository facultyRepository;
    public FacultyService(FacultyRepository facultyRepository){
        this.facultyRepository = facultyRepository;
    }

    public Faculty getSingleFaculty(long id) throws FacultyNotFoundException {
        Optional<Faculty> singleFaculty = facultyRepository.findById(id);
        Faculty faculty;
        if(singleFaculty.isEmpty())
        {
            throw new FacultyNotFoundException("Faculty with id " + id + " not found");
        }
        else{
            faculty = singleFaculty.get();
        }
        return faculty;
    }

    public List<Faculty> getAllFaculty(){
        List<Faculty> allFaculty = facultyRepository.findAll();
        return allFaculty;
    }

    public Faculty saveFaculty(Faculty faculty)
    {
        Faculty postFaculty = facultyRepository.save(faculty);
        return postFaculty;
    }
}
