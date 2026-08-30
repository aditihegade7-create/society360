package com.society.dao.Resident_dao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;

import com.society.model.Resident_model.Amenities;
import com.society.config.FirebaseConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AmenitiesDAO {

    private final Firestore db;

    public AmenitiesDAO() {
        db = FirebaseConfig.getFirestore();
    }

    // =========================================================
    // FETCH ALL AMENITIES
    // =========================================================

    public List<Amenities> getAllAmenities() {

        List<Amenities> amenities = new ArrayList<>();

        try {

            ApiFuture<QuerySnapshot> future =
                    db.collection("Amenities").get();

            QuerySnapshot snapshot =
                    future.get();

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                Amenities amenity =
                        document.toObject(Amenities.class);

                if (amenity != null) {

                    // If amenityId is not stored in document,
                    // use Firestore document ID
                    if (amenity.getAmenityId() == null ||
                            amenity.getAmenityId().isEmpty()) {

                        amenity.setAmenityId(
                                document.getId()
                        );
                    }

                    amenities.add(amenity);
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error fetching amenities: "
                            + e.getMessage()
            );

            e.printStackTrace();
        }

        return amenities;
    }

    // =========================================================
    // SAVE AMENITY BOOKING
    // =========================================================

    public String saveBooking(

            Amenities amenity,

            String bookingDate,

            String startTime,

            String endTime,

            String bookingStatus,

            String paymentStatus,

            String amount) {

        try {

            String bookingId =
                    UUID.randomUUID().toString();

            Map<String, Object> booking =
                    new HashMap<>();

            // =================================================
            // BOOKING INFORMATION
            // =================================================

            booking.put(
                    "bookingId",
                    bookingId
            );

            booking.put(
                    "amenityId",
                    amenity.getAmenityId()
            );

            booking.put(
                    "amenityName",
                    amenity.getAmenityName()
            );

            booking.put(
                    "description",
                    amenity.getDescription()
            );

            // =================================================
            // DATE & TIME
            // =================================================

            booking.put(
                    "bookingDate",
                    bookingDate
            );

            booking.put(
                    "startTime",
                    startTime
            );

            booking.put(
                    "endTime",
                    endTime
            );

            // =================================================
            // PAYMENT
            // =================================================

            booking.put(
                    "amount",
                    amount
            );

            booking.put(
                    "paymentStatus",
                    paymentStatus
            );

            // =================================================
            // BOOKING STATUS
            // =================================================

            booking.put(
                    "bookingStatus",
                    bookingStatus
            );

            // =================================================
            // TIMESTAMP
            // =================================================

            booking.put(
                    "createdAt",
                    System.currentTimeMillis()
            );

            // =================================================
            // SAVE TO FIRESTORE
            // =================================================

            DocumentReference document =
                    db.collection("AmenityBookings")
                            .document(bookingId);

            document.set(booking).get();

            System.out.println(
                    "Amenity booking saved successfully"
            );

            System.out.println(
                    "Booking ID: "
                            + bookingId
            );

            return bookingId;

        } catch (Exception e) {

            System.out.println(
                    "Error saving amenity booking: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return null;
        }
    }

    // =========================================================
    // FETCH ALL BOOKINGS
    // =========================================================

    public List<Map<String, Object>> getAllBookings() {

        List<Map<String, Object>> bookings =
                new ArrayList<>();

        try {

            QuerySnapshot snapshot =
                    db.collection("AmenityBookings")
                            .get()
                            .get();

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                Map<String, Object> data =
                        document.getData();

                if (data != null) {

                    bookings.add(data);
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error fetching bookings: "
                            + e.getMessage()
            );

            e.printStackTrace();
        }

        return bookings;
    }
}