package com.society.model.Secretary_model;

public class Payment {

    // =========================================================
    // AMENITY DETAILS
    // =========================================================

    private String amenityName;
    private String price;
    private String description;
    private String availability;

    // =========================================================
    // BOOKING DETAILS
    // =========================================================

    private String bookingId;
    private String residentName;
    private String flatNo;
    private String bookingDate;
    private String startTime;
    private String endTime;
    private String status;

    // =========================================================
    // PAYMENT DETAILS
    // =========================================================

    private String paymentAmount;
    private String paymentStatus;

    // =========================================================
    // REQUIRED BY FIRESTORE
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
            String bookingId,
            String residentName,
            String flatNo,
            String amenityName,
            String bookingDate,
            String startTime,
            String endTime,
            String status) {

        this.bookingId = bookingId;
        this.residentName = residentName;
        this.flatNo = flatNo;
        this.amenityName = amenityName;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    // =========================================================
    // GETTER / SETTER - AMENITY NAME
    // =========================================================

    public String getAmenityName() {
        return amenityName;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    // =========================================================
    // GETTER / SETTER - PRICE
    // =========================================================

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    // =========================================================
    // GETTER / SETTER - DESCRIPTION
    // =========================================================

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // =========================================================
    // GETTER / SETTER - AVAILABILITY
    // =========================================================

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    // =========================================================
    // GETTER / SETTER - BOOKING ID
    // =========================================================

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    // =========================================================
    // GETTER / SETTER - RESIDENT NAME
    // =========================================================

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    // =========================================================
    // GETTER / SETTER - FLAT NO
    // =========================================================

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    // =========================================================
    // GETTER / SETTER - BOOKING DATE
    // =========================================================

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    // =========================================================
    // GETTER / SETTER - START TIME
    // =========================================================

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    // =========================================================
    // GETTER / SETTER - END TIME
    // =========================================================

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    // =========================================================
    // GETTER / SETTER - STATUS
    // =========================================================

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // =========================================================
    // GETTER / SETTER - PAYMENT AMOUNT
    // =========================================================

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    // =========================================================
    // GETTER / SETTER - PAYMENT STATUS
    // =========================================================

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // =========================================================
    // TO STRING
    // =========================================================

    @Override
    public String toString() {

        return "Payment{" +
                "amenityName='" + amenityName + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", availability='" + availability + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", residentName='" + residentName + '\'' +
                ", flatNo='" + flatNo + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status='" + status + '\'' +
                ", paymentAmount='" + paymentAmount + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}