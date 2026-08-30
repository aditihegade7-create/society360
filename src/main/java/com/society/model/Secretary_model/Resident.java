package com.society.model.Secretary_model;

public class Resident {

    private String name;
    private String flat;
    private String mobile;
    private String email;
    private String status;


    // Default constructor
    public Resident() {
    }

    // Parameterized constructor
    public Resident(String name, String flat, String mobile, String email, String status) {
        this.name = name;
        this.flat = flat;
        this.mobile = mobile;
        this.email = email;
        this.status = status;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for flat
    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    // Getter and Setter for mobile
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}