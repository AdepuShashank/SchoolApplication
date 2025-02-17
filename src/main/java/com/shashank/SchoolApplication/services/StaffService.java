package com.shashank.SchoolApplication.services;

import com.shashank.SchoolApplication.Exceptionhandler.StaffNotFoundException;
import com.shashank.SchoolApplication.Repository.StaffRepository;
import com.shashank.SchoolApplication.models.Staff;
import org.springframework.stereotype.Service;

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
}
