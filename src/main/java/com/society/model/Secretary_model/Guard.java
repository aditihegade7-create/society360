package com.society.model.Secretary_model;

public class Guard {

    private String id;
    private String name;
    private String mobile;
    private String shift;
    private String email;
    private String status;
    private String assignedGate;

    // =====================================================
    // DEFAULT CONSTRUCTOR
    // Required by Firestore
    // =====================================================

    public Guard() {
    }

    // =====================================================
    // PARAMETERIZED CONSTRUCTOR
    // =====================================================

    public Guard(
            String name,
            String mobile,
            String shift,
            String email,
            String status,
            String assignedGate) {

        this.name = name;
        this.mobile = mobile;
        this.mobile = mobile;
        this.shift = shift;
        this.email = email;
        this.status = status;
        this.assignedGate = assignedGate;
    }

    // =====================================================
    // ID
    // =====================================================

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    // MOBILE
    // =====================================================

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    // =====================================================
    // SHIFT
    // =====================================================

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
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

    // =====================================================
    // ASSIGNED GATE
    // =====================================================

    public String getAssignedGate() {
        return assignedGate;
    }

    public void setAssignedGate(String assignedGate) {
        this.assignedGate = assignedGate;
    }
}