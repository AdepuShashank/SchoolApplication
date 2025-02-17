package com.shashank.SchoolApplication.DTOs;

import com.shashank.SchoolApplication.models.Gender;

public class StaffDTO {
    private String name;
    private String subject;
    private Gender gender;
    private String number;

    public StaffDTO(String name, String subject, Gender gender, String number) {
        this.name = name;
        this.subject = subject;
        this.gender = gender;
        this.number = number;
    }

    public StaffDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
