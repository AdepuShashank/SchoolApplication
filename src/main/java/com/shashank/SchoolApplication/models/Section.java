package com.shashank.SchoolApplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
@Entity
public class Section {
    @Id
    private String sectionName;
    @ManyToOne
    private Student student;
    public Section(String sectionName, Student student) {
        this.sectionName = sectionName;
        this.student = student;
    }

    public Section() {
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
}
