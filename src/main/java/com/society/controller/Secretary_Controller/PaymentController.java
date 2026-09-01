package com.society.controller.Secretary_Controller;

import java.util.List;

import com.society.dao.Secretary_dao.PaymentDao;
import com.society.model.Secretary_model.Payment;

public class PaymentController {

    // =========================================================
    // DAO
    // =========================================================

    private final PaymentDao paymentDao;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public PaymentController() {

        paymentDao =
                new PaymentDao();
    }

    // =========================================================
    // ADD AMENITY
    // =========================================================

    public boolean addAmenity(
            String name,
            String price,
            String description,
            String availability) {

        return paymentDao.addAmenity(
                name,
                price,
                description,
                availability
        );
    }

    // =========================================================
    // GET ALL AMENITIES
    // =========================================================

    public List<Payment> getAllAmenities() {

        return paymentDao.getAllAmenities();
    }

    // =========================================================
    // GET ALL BOOKINGS
    // =========================================================

    public List<Payment> getAllBookings() {

        return paymentDao.getAllBookings();
    }

    // =========================================================
    // UPDATE BOOKING STATUS
    // =========================================================

    public boolean updateBookingStatus(
            String email,
            String bookingId,
            String newStatus) {

        return paymentDao.updateBookingStatus(
                email,
                bookingId,
                newStatus
        );
    }
}