package com.shashank.SchoolApplication.Controllers;

import com.shashank.SchoolApplication.models.Staff;
import com.shashank.SchoolApplication.services.StaffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
