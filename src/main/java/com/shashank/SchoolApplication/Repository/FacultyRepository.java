package com.shashank.SchoolApplication.Repository;

import com.shashank.SchoolApplication.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}
