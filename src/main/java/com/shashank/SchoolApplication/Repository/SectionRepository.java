package com.shashank.SchoolApplication.Repository;

import com.shashank.SchoolApplication.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section,String> {
}
