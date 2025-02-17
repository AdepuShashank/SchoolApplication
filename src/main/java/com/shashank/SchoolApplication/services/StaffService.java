package com.shashank.SchoolApplication.services;

import com.shashank.SchoolApplication.DTOs.StaffDTO;
import com.shashank.SchoolApplication.Exceptionhandler.StaffNotFoundException;
import com.shashank.SchoolApplication.Repository.StaffRepository;
import com.shashank.SchoolApplication.models.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Staff GetSingleStaff(long id) throws StaffNotFoundException {
        Staff staff ;
        Optional<Staff> getById = staffRepository.findById(id);

        if(getById.isEmpty()) {
            throw new StaffNotFoundException("no one with that id");
        }
        else
        {
            staff = getById.get();
        }
        return staff;
    }
    public List<StaffDTO> GetAllStaff() {
        List<Staff> allStaff = staffRepository.findAll();
        List<StaffDTO> sDTO = new ArrayList<>();

        for(Staff s : allStaff){
            StaffDTO sfDto = new StaffDTO();

            sfDto.setName(s.getName());
            sfDto.setSubject(s.getSubject());
            sfDto.setGender(s.getGender());
            sfDto.setNumber(s.getNumber());

            sDTO.add(sfDto);

        }

        return sDTO;
    }

    public Staff SaveStaff(Staff staff) {
        Staff newStaff = staffRepository.save(staff);
        return newStaff;
    }
    public Staff UpdateStaff(long id,String name,String subject,String number) throws StaffNotFoundException {
        Optional<Staff> previouslySaved = staffRepository.findById(id);
        if(previouslySaved.isEmpty()) {
            throw new StaffNotFoundException("no one with that id");
        }
        else {
            Staff updateStaff = previouslySaved.get();

            if(name!=null) {
                updateStaff.setName(name);
            }
            if(subject!=null) {
                updateStaff.setSubject(subject);
            }
            if(number!=null) {
                updateStaff.setNumber(number);
            }
            Staff updatedStaff = staffRepository.save(updateStaff);

            return updatedStaff;
        }
    }
    public String DeleteSingleStaff(long id) throws StaffNotFoundException {
        Optional<Staff> staffInDB = staffRepository.findById(id);
        if(staffInDB.isEmpty())
        {
            throw new StaffNotFoundException("not found");
        }
        else
        {
            staffRepository.deleteById(id);
        }
        return "Deleted Staff " + id;
    }


}
