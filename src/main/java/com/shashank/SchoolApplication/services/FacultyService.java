package com.shashank.SchoolApplication.services;

import com.shashank.SchoolApplication.DTOs.FacultyDTO;
import com.shashank.SchoolApplication.Exceptionhandler.FacultyNotFoundException;
import com.shashank.SchoolApplication.Mappers.FacultyMapper;
import com.shashank.SchoolApplication.Repository.FacultyRepository;
import com.shashank.SchoolApplication.models.Faculty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacultyService {

    FacultyRepository facultyRepository;
    FacultyMapper facultyMapper;
    public FacultyService(FacultyRepository facultyRepository,FacultyMapper facultyMapper){
        this.facultyRepository = facultyRepository;
        this.facultyMapper = facultyMapper;
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

    public Faculty saveFaculty(Faculty faculty) {
        Faculty postFaculty = facultyRepository.save(faculty);
        return postFaculty;
    }

    public FacultyDTO UpdateFaculty(long id , String name,String email, String section , String number){
        Optional<Faculty> prevFaculty = facultyRepository.findById(id);
        if(prevFaculty.isEmpty()){
            throw new FacultyNotFoundException("Faculty with id " + id + " not found");
        }
        else{
            Faculty facultyToUpdate = prevFaculty.get();
            if(name!=null){
                facultyToUpdate.setName(name);
            }
            if(email!=null){
                facultyToUpdate.setEmail(email);
            }
            if(section!=null){
                facultyToUpdate.setSection(section);
            }
            if(number!=null){
                facultyToUpdate.setNumber(number);
            }
            facultyRepository.save(facultyToUpdate);
            Faculty updatedFaculty = facultyToUpdate;
            FacultyDTO updatedFacultyDTO = facultyMapper.toFacultyDTO(updatedFaculty);

            return updatedFacultyDTO;
        }
    }

    public String deleteFaculty(long id)throws FacultyNotFoundException {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        if(faculty.isEmpty()){
            throw  new FacultyNotFoundException("Faculty with id " + id + " not found");
        }
        else{
            facultyRepository.deleteById(id);
        }
        return "Faculty with id " + id + "deleted";
    }


}
