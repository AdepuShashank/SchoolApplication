package com.shashank.SchoolApplication.Mappers;

import com.shashank.SchoolApplication.DTOs.StaffDTO;
import com.shashank.SchoolApplication.models.Staff;
import org.springframework.stereotype.Component;

@Component
public class StaffMapper {
    public Staff toStaff(StaffDTO staffDTO) {
        Staff staff = new Staff();
        staff.setName(staffDTO.getName());
        staff.setSubject(staffDTO.getSubject());
        staff.setNumber(staffDTO.getNumber());
        staff.setSubject(staffDTO.getSubject());
        return staff;
    }
    public StaffDTO toStaffDto(Staff staff){
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setName(staff.getName());
        staffDTO.setSubject(staff.getSubject());
        staffDTO.setNumber(staff.getNumber());
        staffDTO.setGender(staff.getGender());

        return staffDTO;
    }
}
