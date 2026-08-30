package com.society.model.Secretary_model;

public class Notice {

    private String title;
    private String description;
    private String date;
    private String status;

    // =====================================================
    // DEFAULT CONSTRUCTOR
    // Required by Firestore
    // =====================================================

    public Notice() {
    }

    // =====================================================
    // PARAMETERIZED CONSTRUCTOR
    // =====================================================

    public Notice(
            String title,
            String description,
            String date,
            String status) {

        this.title = title;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    // =====================================================
    // GETTERS
    // =====================================================

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    // =====================================================
    // SETTERS
    // =====================================================

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}