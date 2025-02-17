package com.shashank.SchoolApplication.models;

import jakarta.persistence.Entity;

@Entity
public class Student extends BaseModel {
    private String name;
    private String email;
    private int standard;
    private String section;
    private String number;

    public Student(String name, String email, int standard, String section, String number) {
        this.name = name;
        this.email = email;
        this.standard = standard;
        this.section = section;
        this.number = number;
    }
    public Student() {}

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

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", standard=" + standard +
                ", section='" + section + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
