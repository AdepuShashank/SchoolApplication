package com.shashank.SchoolApplication.Controllers;

import com.shashank.SchoolApplication.models.Staff;
import com.shashank.SchoolApplication.services.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController {
    StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
    @GetMapping("/staff/{id}")
    public Staff getById(@PathVariable("id") long id ) {
        Staff sf = staffService.GetSingleStaff(id);
        return sf;
    }
    @GetMapping("/staff")
    public List<Staff> getAllStaff() {
        List<Staff> allStaff = staffService.GetAllStaff();
        return allStaff;
    }

    @PostMapping("/staff")
    public Staff saveStaff(@RequestBody Staff staff) {
        Staff newStaff = staffService.SaveStaff(staff);
        return newStaff;
    }

    @PutMapping("/staff/{id}")
    public Staff updateStaff(@PathVariable("id") long id,
                             @RequestBody Staff staff) {
        Staff updateStaff = staffService.UpdateStaff(id,
                staff.getName(),
                staff.getSubject(),
                staff.getNumber());

        return updateStaff;
    }

    @DeleteMapping("staff/{id}")
    public String deleteStaff(@PathVariable("id")long id) {
        return staffService.DeleteSingleStaff(id);
    }

}
