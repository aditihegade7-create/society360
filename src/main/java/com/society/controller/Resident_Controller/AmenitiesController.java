package com.society.controller.Resident_Controller;

import com.society.dao.Resident_dao.AmenitiesDAO;
import com.society.model.Resident_model.Amenities;

import java.util.List;

public class AmenitiesController {

    private final AmenitiesDAO amenitiesDAO;

    public AmenitiesController() {

        amenitiesDAO =
                new AmenitiesDAO();
    }

    // Fetch amenities
    public List<Amenities> getAmenities() {

        return amenitiesDAO.getAllAmenities();
    }


    // Save booking
    public String saveBooking(
            Amenities amenity,
            String bookingDate,
            String startTime,
            String endTime,
            String flatNo,
            String residentName,
            String paymentAmount) {

        return amenitiesDAO.saveBooking(
                amenity,
                bookingDate,
                startTime,
                endTime,
                flatNo,
                residentName,
                paymentAmount
        );
    }
}