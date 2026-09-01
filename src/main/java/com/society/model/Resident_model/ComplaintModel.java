package com.society.model.Resident_model;

import java.util.Date;

public class ComplaintModel {

    // =========================================================
    // FIELDS
    // =========================================================

    private String id;
    private String email;
    private String flatNumber;
    private String category;
    private String title;
    private String description;
    private String imageFileName;
    private String preferredDate;
    private String status;
    private Date createdAt;

    // =========================================================
    // SOCIETY
    // =========================================================
    /*
     * Society name of the Resident.
     *
     * This will be automatically fetched from
     * Residents/{email}
     * when complaint is created.
     */

    private String society;

    // =========================================================
    // DEFAULT CONSTRUCTOR
    // =========================================================

    public ComplaintModel() {
    }

    // =========================================================
    // PARAMETERIZED CONSTRUCTOR
    // =========================================================

    public ComplaintModel(
            String id,
            String email,
            String flatNumber,
            String category,
            String title,
            String description,
            String imageFileName,
            String preferredDate,
            String status,
            Date createdAt,
            String society) {

        this.id = id;
        this.email = email;
        this.flatNumber = flatNumber;
        this.category = category;
        this.title = title;
        this.description = description;
        this.imageFileName = imageFileName;
        this.preferredDate = preferredDate;
        this.status = status;
        this.createdAt = createdAt;
        this.society = society;
    }

    // =========================================================
    // GET ID
    // =========================================================

    public String getId() {
        return id;
    }

    // =========================================================
    // SET ID
    // =========================================================

    public void setId(String id) {
        this.id = id;
    }

    // =========================================================
    // GET EMAIL
    // =========================================================

    public String getEmail() {
        return email;
    }

    // =========================================================
    // SET EMAIL
    // =========================================================

    public void setEmail(String email) {
        this.email = email;
    }

    // =========================================================
    // GET FLAT NUMBER
    // =========================================================

    public String getFlatNumber() {
        return flatNumber;
    }

    // =========================================================
    // SET FLAT NUMBER
    // =========================================================

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    // =========================================================
    // GET CATEGORY
    // =========================================================

    public String getCategory() {
        return category;
    }

    // =========================================================
    // SET CATEGORY
    // =========================================================

    public void setCategory(String category) {
        this.category = category;
    }

    // =========================================================
    // GET TITLE
    // =========================================================

    public String getTitle() {
        return title;
    }

    // =========================================================
    // SET TITLE
    // =========================================================

    public void setTitle(String title) {
        this.title = title;
    }

    // =========================================================
    // GET DESCRIPTION
    // =========================================================

    public String getDescription() {
        return description;
    }

    // =========================================================
    // SET DESCRIPTION
    // =========================================================

    public void setDescription(String description) {
        this.description = description;
    }

    // =========================================================
    // GET IMAGE FILE NAME
    // =========================================================

    public String getImageFileName() {
        return imageFileName;
    }

    // =========================================================
    // SET IMAGE FILE NAME
    // =========================================================

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    // =========================================================
    // GET PREFERRED DATE
    // =========================================================

    public String getPreferredDate() {
        return preferredDate;
    }

    // =========================================================
    // SET PREFERRED DATE
    // =========================================================

    public void setPreferredDate(String preferredDate) {
        this.preferredDate = preferredDate;
    }

    // =========================================================
    // GET STATUS
    // =========================================================

    public String getStatus() {
        return status;
    }

    // =========================================================
    // SET STATUS
    // =========================================================

    public void setStatus(String status) {
        this.status = status;
    }

    // =========================================================
    // GET CREATED AT
    // =========================================================

    public Date getCreatedAt() {
        return createdAt;
    }

    // =========================================================
    // SET CREATED AT
    // =========================================================

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    // =========================================================
    // GET SOCIETY
    // =========================================================

    public String getSociety() {
        return society;
    }

    // =========================================================
    // SET SOCIETY
    // =========================================================

    public void setSociety(String society) {
        this.society = society;
    }

    // =========================================================
    // TO STRING
    // =========================================================

    @Override
    public String toString() {

        return "ComplaintModel{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", flatNumber='" + flatNumber + '\'' +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageFileName='" + imageFileName + '\'' +
                ", preferredDate='" + preferredDate + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", society='" + society + '\'' +
                '}';
    }
}