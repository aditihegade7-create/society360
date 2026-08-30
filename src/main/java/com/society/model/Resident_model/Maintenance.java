package com.society.model.Resident_model;

public class Maintenance {

    private String amount;
    private String date;
    private String flatNo;
    private String month;
    private String residentName;
    private String status;

    // Firestore document ID
    private String documentId;

    public Maintenance() {
    }

    public Maintenance(String amount, String date, String flatNo,
                       String month, String residentName, String status) {
        this.amount = amount;
        this.date = date;
        this.flatNo = flatNo;
        this.month = month;
        this.residentName = residentName;
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
}