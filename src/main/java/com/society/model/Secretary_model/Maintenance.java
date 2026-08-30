
package com.society.model.Secretary_model;

public class Maintenance {
    private String email;
    private String residentName;
    private String flatNo;
    private String amount;
    private String month;
    private String date;
    private String status;

    // =====================================================
    // REQUIRED BY FIRESTORE
    // =====================================================

    public Maintenance() {
    }

    // =====================================================
    // PARAMETERIZED CONSTRUCTOR
    // =====================================================

    public Maintenance(
            String email,
            String residentName,
            String flatNo,
            String amount,
            String month,
            String date,
            String status) {

        this.email = email;

        this.residentName = residentName;
        this.flatNo = flatNo;
        this.amount = amount;
        this.month = month;
        this.date = date;
        this.status = status;
    }

    // =====================================================
    // RESIDENT NAME
    // =====================================================
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    // =====================================================
    // FLAT NUMBER
    // =====================================================

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    // =====================================================
    // AMOUNT
    // =====================================================

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    // =====================================================
    // MONTH
    // =====================================================

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    // =====================================================
    // DATE
    // =====================================================

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
