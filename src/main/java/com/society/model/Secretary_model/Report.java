package com.society.model.Secretary_model;

public class Report {

    private String source;
    private String type;
    private String title;
    private String details;
    private String date;
    private String status;

    // Required by Firestore
    public Report() {
    }

    public Report(String source,
                  String type,
                  String title,
                  String details,
                  String date,
                  String status) {

        this.source = source;
        this.type = type;
        this.title = title;
        this.details = details;
        this.date = date;
        this.status = status;
    }

    // ============================================================
    // GETTERS
    // ============================================================

    public String getSource() {
        return source;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    // ============================================================
    // SETTERS
    // ============================================================

    public void setSource(String source) {
        this.source = source;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "Report{" +
                "source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}