package com.shashank.SchoolApplication.Repository;

import com.shashank.SchoolApplication.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findBySection(String section);
}
