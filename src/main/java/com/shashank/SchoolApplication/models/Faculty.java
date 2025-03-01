package com.shashank.SchoolApplication.models;

import jakarta.persistence.Entity;

@Entity
public class Faculty extends BaseModel{
    private long faculty_id;
    private String name;
    private String email;
    private int standard;
    private String section;
    private String number;

    public Faculty(int faculty_id, String name, String email,int standard, String section, String number) {
        this.faculty_id = faculty_id;
        this.name = name;
        this.email = email;
        this.standard = standard;
        this.section = section;
        this.number = number;
    }

    public Faculty() {
    }

    public long getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(long faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "faculty_id=" + faculty_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", standard='" + standard + '\'' +
                ", section='" + section + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
