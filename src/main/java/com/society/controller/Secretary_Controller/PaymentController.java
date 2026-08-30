package com.society.controller.Secretary_Controller;

import java.util.List;

import com.society.dao.Secretary_dao.PaymentDao;
import com.society.model.Secretary_model.Payment;

public class PaymentController {

    // =========================================================
    // DAO
    // =========================================================

    private PaymentDao paymentDao;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public PaymentController() {

        paymentDao = new PaymentDao();
    }

    // =========================================================
    // ADD AMENITY
    // =========================================================

    public boolean addAmenity(
            String name,
            String price,
            String description,
            String availability) {

        // -----------------------------------------------------
        // VALIDATION
        // -----------------------------------------------------

        if (name == null || name.trim().isEmpty()) {

            System.out.println(
                    "PaymentController: Amenity name is empty."
            );

            return false;
        }

        if (price == null || price.trim().isEmpty()) {

            System.out.println(
                    "PaymentController: Price is empty."
            );

            return false;
        }

        if (description == null
                || description.trim().isEmpty()) {

            System.out.println(
                    "PaymentController: Description is empty."
            );

            return false;
        }

        if (availability == null
                || availability.trim().isEmpty()) {

            System.out.println(
                    "PaymentController: Availability is empty."
            );

            return false;
        }

        // -----------------------------------------------------
        // CREATE PAYMENT / AMENITY OBJECT
        // -----------------------------------------------------

        Payment payment =
                new Payment(
                        name.trim(),
                        price.trim(),
                        description.trim(),
                        availability.trim()
                );

        // -----------------------------------------------------
        // SEND TO DAO
        // -----------------------------------------------------

        return paymentDao.addAmenity(payment);
    }

    // =========================================================
    // GET ALL AMENITIES
    // =========================================================

    public List<Payment> getAllAmenities() {

        return paymentDao.getAllAmenities();
    }

    // =========================================================
    // ADD BOOKING
    // =========================================================

    public boolean addBooking(Payment payment) {

        if (payment == null) {

            System.out.println(
                    "PaymentController: Payment is null."
            );

            return false;
        }

        // -----------------------------------------------------
        // BASIC VALIDATION
        // -----------------------------------------------------

        if (payment.getResidentName() == null
                || payment.getResidentName().trim().isEmpty()) {

            System.out.println(
                    "PaymentController: Resident name is empty."
            );

            return false;
        }

        if (payment.getFlatNo() == null
                || payment.getFlatNo().trim().isEmpty()) {

            System.out.println(
                    "PaymentController: Flat number is empty."
            );

            return false;
        }

        if (payment.getAmenityName() == null
                || payment.getAmenityName().trim().isEmpty()) {

            System.out.println(
                    "PaymentController: Amenity name is empty."
            );

            return false;
        }

        if (payment.getBookingDate() == null
                || payment.getBookingDate().trim().isEmpty()) {

            System.out.println(
                    "PaymentController: Booking date is empty."
            );

            return false;
        }

        // -----------------------------------------------------
        // DEFAULT STATUS
        // -----------------------------------------------------

        if (payment.getStatus() == null
                || payment.getStatus().trim().isEmpty()) {

            payment.setStatus("Pending");
        }

        return paymentDao.addBooking(payment);
    }

    // =========================================================
    // GET ALL BOOKINGS
    // =========================================================

    public List<Payment> getAllBookings() {

        return paymentDao.getAllBookings();
    }

    // =========================================================
    // CHECK SLOT BOOKED
    // =========================================================

    public boolean isSlotBooked(
            String amenityName,
            String bookingDate,
            String startTime,
            String endTime) {

        if (amenityName == null
                || amenityName.trim().isEmpty()) {

            return false;
        }

        if (bookingDate == null
                || bookingDate.trim().isEmpty()) {

            return false;
        }

        if (startTime == null
                || startTime.trim().isEmpty()) {

            return false;
        }

        if (endTime == null
                || endTime.trim().isEmpty()) {

            return false;
        }

        return paymentDao.isSlotBooked(
                amenityName.trim(),
                bookingDate.trim(),
                startTime.trim(),
                endTime.trim()
        );
    }

    // =========================================================
    // UPDATE BOOKING STATUS
    // =========================================================

    public boolean updateBookingStatus(
            Payment payment,
            String status) {

        // -----------------------------------------------------
        // PAYMENT VALIDATION
        // -----------------------------------------------------

        if (payment == null) {

            System.out.println(
                    "PaymentController: Payment is null."
            );

            return false;
        }

        // -----------------------------------------------------
        // STATUS VALIDATION
        // -----------------------------------------------------

        if (status == null
                || status.trim().isEmpty()) {

            System.out.println(
                    "PaymentController: Status is empty."
            );

            return false;
        }

        // -----------------------------------------------------
        // BOOKING ID CHECK
        // -----------------------------------------------------

        String bookingId =
                payment.getBookingId();

        if (bookingId == null
                || bookingId.trim().isEmpty()) {

            System.out.println(
                    "PaymentController: Booking ID is empty."
            );

            return false;
        }

        // -----------------------------------------------------
        // UPDATE MODEL
        // -----------------------------------------------------

        payment.setStatus(
                status.trim()
        );

        // -----------------------------------------------------
        // SEND TO DAO
        // -----------------------------------------------------

        return paymentDao.updateBookingStatus(
                bookingId.trim(),
                status.trim()
        );
    }

    // =========================================================
    // UPDATE BOOKING STATUS USING BOOKING ID
    // =========================================================

    public boolean updateBookingStatus(
            String bookingId,
            String status) {

        if (bookingId == null
                || bookingId.trim().isEmpty()) {

            System.out.println(
                    "PaymentController: Booking ID is empty."
            );

            return false;
        }

        if (status == null
                || status.trim().isEmpty()) {

            System.out.println(
                    "PaymentController: Status is empty."
            );

            return false;
        }

        return paymentDao.updateBookingStatus(
                bookingId.trim(),
                status.trim()
        );
    }

    // =========================================================
    // ACCEPT BOOKING
    // =========================================================

    public boolean acceptBooking(
            String bookingId) {

        return updateBookingStatus(
                bookingId,
                "Accepted"
        );
    }

    // =========================================================
    // REJECT BOOKING
    // =========================================================

    public boolean rejectBooking(
            String bookingId) {

        return updateBookingStatus(
                bookingId,
                "Rejected"
        );
    }
}