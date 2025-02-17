package com.shashank.SchoolApplication.models;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Staff extends BaseModel{
    private String name;
    private String role;
    private Gender gender;
    private String number;

    public Staff(String name, String role, Gender gender, String number) {
        this.name = name;
        this.role = role;
        this.gender = gender;
        this.number = number;
    }
    public Staff() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", subject='" + role + '\'' +
                ", gender=" + gender +
                ", number='" + number + '\'' +
                '}';
    }
}
