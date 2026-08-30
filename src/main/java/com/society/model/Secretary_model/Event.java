
package com.society.model.Secretary_model;

public class Event {

    // =====================================================
    // FIELDS
    // =====================================================

    private String eventName;
    private String date;
    private String time;
    private String venue;
    private String status;

    // =====================================================
    // DEFAULT CONSTRUCTOR
    // REQUIRED BY FIRESTORE
    // =====================================================

    public Event() {
    }

    // =====================================================
    // PARAMETERIZED CONSTRUCTOR
    // =====================================================

    public Event(
            String eventName,
            String date,
            String time,
            String venue,
            String status) {

        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.status = status;
    }

    // =====================================================
    // GET EVENT NAME
    // =====================================================

    public String getEventName() {
        return eventName;
    }

    // =====================================================
    // SET EVENT NAME
    // =====================================================

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    // =====================================================
    // GET DATE
    // =====================================================

    public String getDate() {
        return date;
    }

    // =====================================================
    // SET DATE
    // =====================================================

    public void setDate(String date) {
        this.date = date;
    }

    // =====================================================
    // GET TIME
    // =====================================================

    public String getTime() {
        return time;
    }

    // =====================================================
    // SET TIME
    // =====================================================

    public void setTime(String time) {
        this.time = time;
    }

    // =====================================================
    // GET VENUE
    // =====================================================

    public String getVenue() {
        return venue;
    }

    // =====================================================
    // SET VENUE
    // =====================================================

    public void setVenue(String venue) {
        this.venue = venue;
    }

    // =====================================================
    // GET STATUS
    // =====================================================

    public String getStatus() {
        return status;
    }

    // =====================================================
    // SET STATUS
    // =====================================================

    public void setStatus(String status) {
        this.status = status;
    }
}
