package com.society.model.Secretary_model;

public class Owner {

    private String name;
    private String flat;
    private String mobile;
    private String email;
    private String status;

    // =====================================================
    // DEFAULT CONSTRUCTOR
    // Required for Firestore
    // =====================================================

    public Owner() {
    }

    // =====================================================
    // PARAMETERIZED CONSTRUCTOR
    // =====================================================

    public Owner(
            String name,
            String flat,
            String mobile,
            String email,
            String status) {

        this.name = name;
        this.flat = flat;
        this.mobile = mobile;
        this.email = email;
        this.status = status;
    }

    // =====================================================
    // NAME
    // =====================================================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // =====================================================
    // FLAT
    // =====================================================

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    // =====================================================
    // MOBILE
    // =====================================================

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    // =====================================================
    // EMAIL
    // =====================================================

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // =====================================================
    // STATUS
    // =====================================================

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}