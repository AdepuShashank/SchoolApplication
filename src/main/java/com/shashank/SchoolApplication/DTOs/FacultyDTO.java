package com.shashank.SchoolApplication.DTOs;

public class FacultyDTO {
    private long faculty_id;
    private String name;
    private String email;
    private String section;
    private String number;
    public FacultyDTO(int faculty_id, String name, String email, String section, String number) {
        this.faculty_id = faculty_id;
        this.name = name;
        this.email = email;
        this.section = section;
        this.number = number;
    }

    public FacultyDTO() {
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
}
