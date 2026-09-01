package com.society.model.Resident_model;

public class NoticeModel {

    private String title;
    private String date;
    private String description;
    private String status;
    private String noticeId;
    private String senderEmail;


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


    public NoticeModel(
            String title,
            String date,
            String description,
            String status,
            String noticeId,
            String senderEmail) {

        this.title = title;
        this.date = date;
        this.description = description;
        this.status = status;
        this.noticeId = noticeId;
        this.senderEmail = senderEmail;
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


    public String getNoticeId() {
        return noticeId;
    }


    public String getSenderEmail() {
        return senderEmail;
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


    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }


    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }
}