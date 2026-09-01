package com.society.dao.Secretary_dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.Payment;

public class PaymentDao {

    // =========================================================
    // FIRESTORE
    // =========================================================

    private final Firestore firestore;

    // =========================================================
    // SECRETARY EMAIL
    // =========================================================

    private static final String SECRETARY_EMAIL =
            "aditi@gmail.com";

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public PaymentDao() {

        firestore = FirebaseConfig.getFirestore();

        System.out.println(
                "======================================"
        );

        System.out.println(
                "PaymentDao initialized"
        );

        System.out.println(
                "Secretary Email = " + SECRETARY_EMAIL
        );

        System.out.println(
                "======================================"
        );
    }

    // =========================================================
    // NORMALIZE EMAIL
    // =========================================================

    private String normalizeEmail(String email) {

        if (email == null) {
            return "";
        }

        return email.trim().toLowerCase();
    }

    // =========================================================
    // ADD AMENITY
    // =========================================================

    public boolean addAmenity(
            String name,
            String price,
            String description,
            String availability) {

        try {

            if (name == null || name.trim().isEmpty()) {
                return false;
            }

            if (price == null || price.trim().isEmpty()) {
                return false;
            }

            if (description == null
                    || description.trim().isEmpty()) {
                return false;
            }

            if (availability == null
                    || availability.trim().isEmpty()) {
                return false;
            }

            String amenityId =
                    UUID.randomUUID().toString();

            Map<String, Object> data =
                    new HashMap<>();

            data.put(
                    "amenityId",
                    amenityId
            );

            data.put(
                    "amenityName",
                    name.trim()
            );

            data.put(
                    "price",
                    price.trim()
            );

            data.put(
                    "description",
                    description.trim()
            );

            data.put(
                    "availability",
                    availability.trim()
            );

            data.put(
                    "createdByEmail",
                    SECRETARY_EMAIL
            );

            // =====================================================
            // FIRESTORE PATH
            // =====================================================
            //
            // Amenities
            //    / aditi@gmail.com
            //        / amenities
            //            / amenityId
            //
            // =====================================================

            DocumentReference amenityRef =
                    firestore
                            .collection("Amenities")
                            .document(SECRETARY_EMAIL)
                            .collection("amenities")
                            .document(amenityId);

            amenityRef
                    .set(data)
                    .get();

            System.out.println(
                    "======================================"
            );

            System.out.println(
                    "AMENITY SAVED SUCCESSFULLY"
            );

            System.out.println(
                    "Amenity Name = " + name
            );

            System.out.println(
                    "Amenity ID = " + amenityId
            );

            System.out.println(
                    "Path = " + amenityRef.getPath()
            );

            System.out.println(
                    "======================================"
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "ERROR WHILE ADDING AMENITY"
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // GET ALL AMENITIES
    // =========================================================

    public List<Payment> getAllAmenities() {

        List<Payment> list =
                new ArrayList<>();

        try {

            String secretaryEmail =
                    normalizeEmail(SECRETARY_EMAIL);

            QuerySnapshot snapshot =
                    firestore
                            .collection("Amenities")
                            .document(secretaryEmail)
                            .collection("amenities")
                            .get()
                            .get();

            System.out.println(
                    "======================================"
            );

            System.out.println(
                    "FETCHING AMENITIES"
            );

            System.out.println(
                    "Secretary = " + secretaryEmail
            );

            System.out.println(
                    "Total Amenities = " + snapshot.size()
            );

            System.out.println(
                    "======================================"
            );

            for (QueryDocumentSnapshot document :
                    snapshot.getDocuments()) {

                Payment payment =
                        new Payment();

                payment.setAmenityId(
                        getString(
                                document,
                                "amenityId"
                        )
                );

                // Fallback to Firestore document ID
                if (payment.getAmenityId() == null
                        || payment.getAmenityId()
                                .trim()
                                .isEmpty()) {

                    payment.setAmenityId(
                            document.getId()
                    );
                }

                payment.setAmenityName(
                        getString(
                                document,
                                "amenityName"
                        )
                );

                payment.setPrice(
                        getString(
                                document,
                                "price"
                        )
                );

                payment.setDescription(
                        getString(
                                document,
                                "description"
                        )
                );

                payment.setAvailability(
                        getString(
                                document,
                                "availability"
                        )
                );

                list.add(payment);

                System.out.println(
                        "Amenity = "
                                + payment.getAmenityName()
                                + " | ID = "
                                + payment.getAmenityId()
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "ERROR WHILE FETCHING AMENITIES"
            );

            e.printStackTrace();
        }

        return list;
    }

    // =========================================================
    // GET ALL BOOKINGS
    // =========================================================
    //
    // THIS IS THE IMPORTANT METHOD.
    //
    // It does NOT depend on newly-created amenities.
    //
    // It manually goes through:
    //
    // Amenities
    //    -> secretary email
    //       -> amenities
    //          -> EVERY amenity
    //             -> bookings
    //                -> EVERY resident
    //
    // Therefore old + new amenities both work.
    //
    // =========================================================

    public List<Payment> getAllBookings() {

        List<Payment> list =
                new ArrayList<>();

        try {

            String secretaryEmail =
                    normalizeEmail(SECRETARY_EMAIL);

            // =====================================================
            // GET ALL AMENITIES
            // =====================================================

            QuerySnapshot amenitiesSnapshot =
                    firestore
                            .collection("Amenities")
                            .document(secretaryEmail)
                            .collection("amenities")
                            .get()
                            .get();

            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "FETCHING ALL BOOKINGS FOR SECRETARY"
            );

            System.out.println(
                    "Secretary Email = "
                            + secretaryEmail
            );

            System.out.println(
                    "Amenities Found = "
                            + amenitiesSnapshot.size()
            );

            System.out.println(
                    "=========================================="
            );

            // =====================================================
            // LOOP THROUGH EVERY AMENITY
            // =====================================================

            for (QueryDocumentSnapshot amenityDocument :
                    amenitiesSnapshot.getDocuments()) {

                String amenityId =
                        getString(
                                amenityDocument,
                                "amenityId"
                        );

                if (amenityId.isEmpty()) {

                    amenityId =
                            amenityDocument.getId();
                }

                String amenityName =
                        getString(
                                amenityDocument,
                                "amenityName"
                        );

                System.out.println(
                        "------------------------------------------"
                );

                System.out.println(
                        "Checking Amenity:"
                );

                System.out.println(
                        "Amenity Name = "
                                + amenityName
                );

                System.out.println(
                        "Amenity ID = "
                                + amenityId
                );

                // =================================================
                // BOOKINGS SUBCOLLECTION
                // =================================================

                QuerySnapshot bookingsSnapshot =
                        amenityDocument
                                .getReference()
                                .collection("bookings")
                                .get()
                                .get();

                System.out.println(
                        "Bookings Found = "
                                + bookingsSnapshot.size()
                );

                // =================================================
                // LOOP THROUGH EVERY BOOKING
                // =================================================

                for (QueryDocumentSnapshot bookingDocument :
                        bookingsSnapshot.getDocuments()) {

                    Payment payment =
                            convertBooking(
                                    bookingDocument,
                                    amenityId,
                                    amenityName
                            );

                    if (payment != null) {

                        list.add(payment);

                        System.out.println(
                                "BOOKING FETCHED"
                        );

                        System.out.println(
                                "Booking ID = "
                                        + payment
                                                .getBookingId()
                        );

                        System.out.println(
                                "Resident = "
                                        + payment
                                                .getResidentName()
                        );

                        System.out.println(
                                "Resident Email = "
                                        + payment
                                                .getEmail()
                        );

                        System.out.println(
                                "Amenity = "
                                        + payment
                                                .getAmenityName()
                        );

                        System.out.println(
                                "Date = "
                                        + payment
                                                .getBookingDate()
                        );

                        System.out.println(
                                "Status = "
                                        + payment
                                                .getStatus()
                        );

                        System.out.println(
                                "------------------------------------------"
                        );
                    }
                }
            }

            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "TOTAL BOOKINGS FETCHED = "
                            + list.size()
            );

            System.out.println(
                    "=========================================="
            );

        } catch (Exception e) {

            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "ERROR WHILE FETCHING ALL BOOKINGS"
            );

            System.out.println(
                    "=========================================="
            );

            e.printStackTrace();
        }

        return list;
    }

    // =========================================================
    // CONVERT BOOKING DOCUMENT
    // =========================================================

    private Payment convertBooking(
            DocumentSnapshot document,
            String amenityId,
            String amenityName) {

        try {

            Payment payment =
                    new Payment();

            // =====================================================
            // BOOKING ID
            // =====================================================

            String bookingId =
                    getString(
                            document,
                            "bookingId"
                    );

            if (bookingId.isEmpty()) {

                // fallback
                bookingId =
                        document.getId();
            }

            payment.setBookingId(
                    bookingId
            );

            // =====================================================
            // AMENITY ID
            // =====================================================

            String storedAmenityId =
                    getString(
                            document,
                            "amenityId"
                    );

            if (storedAmenityId.isEmpty()) {

                storedAmenityId =
                        amenityId;
            }

            payment.setAmenityId(
                    storedAmenityId
            );

            // =====================================================
            // AMENITY NAME
            // =====================================================

            String storedAmenityName =
                    getString(
                            document,
                            "amenityName"
                    );

            if (storedAmenityName.isEmpty()) {

                storedAmenityName =
                        amenityName;
            }

            payment.setAmenityName(
                    storedAmenityName
            );

            // =====================================================
            // RESIDENT NAME
            // =====================================================

            payment.setResidentName(
                    getString(
                            document,
                            "residentName"
                    )
            );

            // =====================================================
            // RESIDENT EMAIL
            // =====================================================

            String residentEmail =
                    getString(
                            document,
                            "residentEmail"
                    );

            /*
             * Some of your old bookings may not have
             * residentEmail field.
             *
             * In that case:
             *
             * document ID = resident email
             */

            if (residentEmail.isEmpty()) {

                residentEmail =
                        document.getId();
            }

            payment.setEmail(
                    normalizeEmail(
                            residentEmail
                    )
            );

            // =====================================================
            // FLAT NO
            // =====================================================

            payment.setFlatNo(
                    getString(
                            document,
                            "flatNo"
                    )
            );

            // =====================================================
            // BOOKING DATE
            // =====================================================

            payment.setBookingDate(
                    getString(
                            document,
                            "bookingDate"
                    )
            );

            // =====================================================
            // START TIME
            // =====================================================

            payment.setStartTime(
                    getString(
                            document,
                            "startTime"
                    )
            );

            // =====================================================
            // END TIME
            // =====================================================

            payment.setEndTime(
                    getString(
                            document,
                            "endTime"
                    )
            );

            // =====================================================
            // PAYMENT AMOUNT
            // =====================================================

            payment.setPaymentAmount(
                    getString(
                            document,
                            "paymentAmount"
                    )
            );

            // =====================================================
            // PAYMENT STATUS
            // =====================================================

            String paymentStatus =
                    getString(
                            document,
                            "paymentStatus"
                    );

            payment.setPaymentStatus(
                    paymentStatus
            );

            // =====================================================
            // BOOKING STATUS
            // =====================================================

            String bookingStatus =
                    getString(
                            document,
                            "bookingStatus"
                    );

            if (bookingStatus.isEmpty()) {

                // fallback if old data uses status
                bookingStatus =
                        getString(
                                document,
                                "status"
                        );
            }

            if (bookingStatus.isEmpty()) {

                bookingStatus =
                        "PENDING";
            }

            payment.setStatus(
                    bookingStatus
                            .trim()
                            .toUpperCase()
            );

            return payment;

        } catch (Exception e) {

            System.out.println(
                    "Error converting booking document:"
            );

            e.printStackTrace();

            return null;
        }
    }

    // =========================================================
    // UPDATE BOOKING STATUS
    // =========================================================
    //
    // We first find the booking inside:
    //
    // Amenities
    //    -> secretary
    //       -> amenities
    //          -> amenity
    //             -> bookings
    //
    // =========================================================

    public boolean updateBookingStatus(
            String email,
            String bookingId,
            String newStatus) {

        try {

            email =
                    normalizeEmail(email);

            if (email.isEmpty()) {

                System.out.println(
                        "DAO ERROR: Email is empty."
                );

                return false;
            }

            if (bookingId == null
                    || bookingId.trim().isEmpty()) {

                System.out.println(
                        "DAO ERROR: Booking ID is empty."
                );

                return false;
            }

            if (newStatus == null
                    || newStatus.trim().isEmpty()) {

                System.out.println(
                        "DAO ERROR: Status is empty."
                );

                return false;
            }

            bookingId =
                    bookingId.trim();

            newStatus =
                    newStatus
                            .trim()
                            .toUpperCase();

            if (!newStatus.equals("ACCEPTED")
                    && !newStatus.equals("REJECTED")) {

                System.out.println(
                        "DAO ERROR: Invalid status = "
                                + newStatus
                );

                return false;
            }

            // =====================================================
            // GET ALL AMENITIES
            // =====================================================

            QuerySnapshot amenitiesSnapshot =
                    firestore
                            .collection("Amenities")
                            .document(
                                    normalizeEmail(
                                            SECRETARY_EMAIL
                                    )
                            )
                            .collection("amenities")
                            .get()
                            .get();

            // =====================================================
            // SEARCH BOOKING
            // =====================================================

            for (QueryDocumentSnapshot amenityDocument :
                    amenitiesSnapshot.getDocuments()) {

                QuerySnapshot bookingsSnapshot =
                        amenityDocument
                                .getReference()
                                .collection("bookings")
                                .get()
                                .get();

                for (QueryDocumentSnapshot bookingDocument :
                        bookingsSnapshot.getDocuments()) {

                    String firestoreBookingId =
                            getString(
                                    bookingDocument,
                                    "bookingId"
                            );

                    String residentEmail =
                            getString(
                                    bookingDocument,
                                    "residentEmail"
                            );

                    // Old booking fallback
                    if (residentEmail.isEmpty()) {

                        residentEmail =
                                bookingDocument.getId();
                    }

                    residentEmail =
                            normalizeEmail(
                                    residentEmail
                            );

                    // =================================================
                    // MATCH
                    // =================================================

                    if (bookingId.equals(
                            firestoreBookingId)
                            && email.equals(
                                    residentEmail)) {

                        DocumentReference bookingRef =
                                bookingDocument
                                        .getReference();

                        System.out.println(
                                "=========================================="
                        );

                        System.out.println(
                                "UPDATING BOOKING"
                        );

                        System.out.println(
                                "Resident Email = "
                                        + email
                        );

                        System.out.println(
                                "Booking ID = "
                                        + bookingId
                        );

                        System.out.println(
                                "Amenity = "
                                        + getString(
                                                amenityDocument,
                                                "amenityName"
                                        )
                        );

                        System.out.println(
                                "Path = "
                                        + bookingRef
                                                .getPath()
                        );

                        System.out.println(
                                "New Status = "
                                        + newStatus
                        );

                        System.out.println(
                                "=========================================="
                        );

                        // =================================================
                        // UPDATE
                        // =================================================

                        Map<String, Object> update =
                                new HashMap<>();

                        update.put(
                                "bookingStatus",
                                newStatus
                        );

                        update.put(
                                "residentEmail",
                                email
                        );

                        update.put(
                                "bookingId",
                                bookingId
                        );

                        bookingRef
                                .update(update)
                                .get();

                        // =================================================
                        // VERIFY
                        // =================================================

                        DocumentSnapshot updated =
                                bookingRef
                                        .get()
                                        .get();

                        String status =
                                getString(
                                        updated,
                                        "bookingStatus"
                                );

                        if (newStatus.equalsIgnoreCase(
                                status)) {

                            System.out.println(
                                    "BOOKING STATUS UPDATED SUCCESSFULLY"
                            );

                            return true;
                        }

                        return false;
                    }
                }
            }

            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "BOOKING NOT FOUND"
            );

            System.out.println(
                    "Email = " + email
            );

            System.out.println(
                    "Booking ID = " + bookingId
            );

            System.out.println(
                    "=========================================="
            );

            return false;

        } catch (Exception e) {

            System.out.println(
                    "ERROR WHILE UPDATING BOOKING"
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // GET STRING
    // =========================================================

    private String getString(
            DocumentSnapshot document,
            String field) {

        try {

            Object value =
                    document.get(field);

            if (value == null) {
                return "";
            }

            return String.valueOf(value);

        } catch (Exception e) {

            return "";
        }
    }
}