package com.society.model.Resident_model;


  
import java.util.Date;

public class ComplaintModel {

    private String id;
    private String flatNumber;
    private String category;
    private String title;
    private String description;
    private String imageFileName;
    private String preferredDate;
    private String status;
    private Date createdAt;

    // REQUIRED by Firestore
    public ComplaintModel() {
    }

    public ComplaintModel(
            String id,
            String flatNumber,
            String category,
            String title,
            String description,
            String imageFileName,
            String preferredDate,
            String status,
            Date createdAt) {

        this.id = id;
        this.flatNumber = flatNumber;
        this.category = category;
        this.title = title;
        this.description = description;
        this.imageFileName = imageFileName;
        this.preferredDate = preferredDate;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getPreferredDate() {
        return preferredDate;
    }

    public void setPreferredDate(String preferredDate) {
        this.preferredDate = preferredDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}


