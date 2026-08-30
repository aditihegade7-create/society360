package com.society.dao.Secretary_dao;

import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.Payment;

public class PaymentDao {

    // =========================================================
    // FIRESTORE
    // =========================================================

    private Firestore firestore;

    // =========================================================
    // COLLECTION NAMES
    // =========================================================

    private static final String AMENITY_COLLECTION =
            "Amenities";

    private static final String BOOKING_COLLECTION =
            "Payments";

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public PaymentDao() {

        firestore = FirebaseConfig.getFirestore();

        System.out.println(
                "PaymentDao: Firestore connected."
        );
    }

    // =========================================================
    // ADD AMENITY
    // =========================================================

    public boolean addAmenity(Payment payment) {

        try {

            if (payment == null) {

                System.out.println(
                        "PaymentDao: Amenity is null."
                );

                return false;
            }

            // -------------------------------------------------
            // ADD DOCUMENT
            // -------------------------------------------------

            DocumentReference document =
                    firestore
                            .collection(AMENITY_COLLECTION)
                            .document();

            // -------------------------------------------------
            // SAVE DATA
            // -------------------------------------------------

            document.set(payment).get();

            System.out.println(
                    "Amenity added successfully."
            );

            System.out.println(
                    "Amenity ID: "
                            + document.getId()
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "PaymentDao: Error adding amenity."
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // GET ALL AMENITIES
    // =========================================================

    public List<Payment> getAllAmenities() {

        List<Payment> amenities =
                new ArrayList<>();

        try {

            ApiFuture<QuerySnapshot> future =
                    firestore
                            .collection(AMENITY_COLLECTION)
                            .get();

            QuerySnapshot snapshot =
                    future.get();

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                Payment payment =
                        document.toObject(
                                Payment.class
                        );

                if (payment != null) {

                    payment.setBookingId(
                            document.getId()
                    );

                    amenities.add(payment);
                }
            }

            System.out.println(
                    "Amenities fetched: "
                            + amenities.size()
            );

        } catch (Exception e) {

            System.out.println(
                    "PaymentDao: Error fetching amenities."
            );

            e.printStackTrace();
        }

        return amenities;
    }

    // =========================================================
    // ADD BOOKING
    // =========================================================

    public boolean addBooking(Payment payment) {

        try {

            if (payment == null) {

                System.out.println(
                        "PaymentDao: Booking is null."
                );

                return false;
            }

            // -------------------------------------------------
            // CREATE DOCUMENT
            // -------------------------------------------------

            DocumentReference document =
                    firestore
                            .collection(BOOKING_COLLECTION)
                            .document();

            // -------------------------------------------------
            // SET DOCUMENT ID IN MODEL
            // -------------------------------------------------

            payment.setBookingId(
                    document.getId()
            );

            // -------------------------------------------------
            // DEFAULT STATUS
            // -------------------------------------------------

            if (payment.getStatus() == null
                    || payment.getStatus()
                    .trim()
                    .isEmpty()) {

                payment.setStatus(
                        "Pending"
                );
            }

            // -------------------------------------------------
            // SAVE
            // -------------------------------------------------

            document.set(payment).get();

            System.out.println(
                    "Booking added successfully."
            );

            System.out.println(
                    "Booking ID: "
                            + document.getId()
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "PaymentDao: Error adding booking."
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // GET ALL BOOKINGS
    // =========================================================

    public List<Payment> getAllBookings() {

        List<Payment> bookings =
                new ArrayList<>();

        try {

            ApiFuture<QuerySnapshot> future =
                    firestore
                            .collection(BOOKING_COLLECTION)
                            .get();

            QuerySnapshot snapshot =
                    future.get();

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                Payment payment =
                        document.toObject(
                                Payment.class
                        );

                if (payment != null) {

                    // -----------------------------------------
                    // VERY IMPORTANT
                    // -----------------------------------------
                    // Firestore document ID is stored as
                    // bookingId.
                    //
                    // This is required when Accept / Reject
                    // button is clicked.
                    // -----------------------------------------

                    payment.setBookingId(
                            document.getId()
                    );

                    bookings.add(payment);
                }
            }

            System.out.println(
                    "Bookings fetched: "
                            + bookings.size()
            );

        } catch (Exception e) {

            System.out.println(
                    "PaymentDao: Error fetching bookings."
            );

            e.printStackTrace();
        }

        return bookings;
    }

    // =========================================================
    // CHECK SLOT BOOKED
    // =========================================================

    public boolean isSlotBooked(
            String amenityName,
            String bookingDate,
            String startTime,
            String endTime) {

        try {

            QuerySnapshot snapshot =
                    firestore
                            .collection(BOOKING_COLLECTION)
                            .whereEqualTo(
                                    "amenityName",
                                    amenityName
                            )
                            .whereEqualTo(
                                    "bookingDate",
                                    bookingDate
                            )
                            .whereEqualTo(
                                    "startTime",
                                    startTime
                            )
                            .whereEqualTo(
                                    "endTime",
                                    endTime
                            )
                            .get()
                            .get();

            return !snapshot.isEmpty();

        } catch (Exception e) {

            System.out.println(
                    "PaymentDao: Error checking slot."
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // UPDATE BOOKING STATUS
    // =========================================================

    public boolean updateBookingStatus(
            String bookingId,
            String status) {

        try {

            // -------------------------------------------------
            // VALIDATION
            // -------------------------------------------------

            if (bookingId == null
                    || bookingId.trim().isEmpty()) {

                System.out.println(
                        "PaymentDao: Booking ID is empty."
                );

                return false;
            }

            if (status == null
                    || status.trim().isEmpty()) {

                System.out.println(
                        "PaymentDao: Status is empty."
                );

                return false;
            }

            // -------------------------------------------------
            // DOCUMENT REFERENCE
            // -------------------------------------------------

            DocumentReference document =
                    firestore
                            .collection(BOOKING_COLLECTION)
                            .document(
                                    bookingId
                            );

            // -------------------------------------------------
            // CHECK DOCUMENT
            // -------------------------------------------------

            DocumentSnapshot snapshot =
                    document.get().get();

            if (!snapshot.exists()) {

                System.out.println(
                        "PaymentDao: Booking not found."
                );

                return false;
            }

            // -------------------------------------------------
            // UPDATE STATUS
            // -------------------------------------------------

            document
                    .update(
                            "status",
                            status
                    )
                    .get();

            System.out.println(
                    "Booking status updated successfully."
            );

            System.out.println(
                    "Booking ID: "
                            + bookingId
            );

            System.out.println(
                    "New Status: "
                            + status
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "PaymentDao: Error updating booking status."
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // UPDATE AMENITY AVAILABILITY
    // =========================================================

    public boolean updateAmenityAvailability(
            String amenityId,
            String availability) {

        try {

            if (amenityId == null
                    || amenityId.trim().isEmpty()) {

                return false;
            }

            if (availability == null
                    || availability.trim().isEmpty()) {

                return false;
            }

            firestore
                    .collection(AMENITY_COLLECTION)
                    .document(amenityId)
                    .update(
                            "availability",
                            availability
                    )
                    .get();

            System.out.println(
                    "Amenity availability updated."
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "PaymentDao: Error updating availability."
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // DELETE AMENITY
    // =========================================================

    public boolean deleteAmenity(
            String amenityId) {

        try {

            if (amenityId == null
                    || amenityId.trim().isEmpty()) {

                return false;
            }

            firestore
                    .collection(AMENITY_COLLECTION)
                    .document(amenityId)
                    .delete()
                    .get();

            System.out.println(
                    "Amenity deleted successfully."
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "PaymentDao: Error deleting amenity."
            );

            e.printStackTrace();

            return false;
        }
    }
}