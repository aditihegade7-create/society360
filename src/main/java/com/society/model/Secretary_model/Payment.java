package com.society.model.Secretary_model;

public class Payment {

    // =========================================================
    // AMENITY DATA
    // =========================================================

    private String amenityId;
    private String amenityName;
    private String price;
    private String description;
    private String availability;

    // =========================================================
    // USER EMAIL
    // =========================================================

    private String email;

    // =========================================================
    // BOOKING DATA
    // =========================================================

    private String bookingId;
    private String residentName;
    private String flatNo;
    private String bookingDate;
    private String startTime;
    private String endTime;

    // =========================================================
    // PAYMENT DATA
    // =========================================================

    private String paymentAmount;
    private String paymentStatus;

    // =========================================================
    // BOOKING STATUS
    // =========================================================

    private String status;

    // =========================================================
    // DEFAULT CONSTRUCTOR
    // =========================================================

    public Payment() {
    }

    // =========================================================
    // AMENITY CONSTRUCTOR
    // =========================================================

    public Payment(
            String amenityName,
            String price,
            String description,
            String availability) {

        this.amenityName = amenityName;
        this.price = price;
        this.description = description;
        this.availability = availability;
    }

    // =========================================================
    // BOOKING CONSTRUCTOR
    // =========================================================

    public Payment(
            String residentName,
            String flatNo,
            String amenityName,
            String bookingDate,
            String startTime,
            String endTime,
            String status) {

        this.residentName = residentName;
        this.flatNo = flatNo;
        this.amenityName = amenityName;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    // =========================================================
    // GETTERS / SETTERS
    // =========================================================

    public String getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(String amenityId) {
        this.amenityId = amenityId;
    }

    public String getAmenityName() {
        return amenityName;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}