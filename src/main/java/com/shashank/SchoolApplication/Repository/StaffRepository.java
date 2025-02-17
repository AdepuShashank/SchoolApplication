package com.shashank.SchoolApplication.Repository;

import com.shashank.SchoolApplication.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Long> {
}
