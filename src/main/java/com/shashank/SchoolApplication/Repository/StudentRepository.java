package com.shashank.SchoolApplication.Repository;

import com.shashank.SchoolApplication.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
