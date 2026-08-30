package com.society.model.Resident_model;

public class NoticeModel {

    private String title;
    private String date;
    private String description;
    private String status;

    public NoticeModel() {
    }

    public NoticeModel(
            String title,
            String date,
            String description,
            String status) {

        this.title = title;
        this.date = date;
        this.description = description;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
