package com.society.dao.Resident_dao;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.society.model.Resident_model.ComplaintModel;

import java.util.ArrayList;
import java.util.List;

public class ComplaintDAO {

    private final Firestore firestore;

    // =========================================================
    // COLLECTION NAMES
    // =========================================================

    /*
     * Complaint structure:
     *
     * complaints
     *    └── residentEmail
     *         └── complaints
     *              └── complaintId
     */

    private static final String COLLECTION = "complaints";
    private static final String SUB_COLLECTION = "complaints";

    /*
     * Resident signup collection.
     *
     * Residents
     *    └── residentEmail
     */

    private static final String RESIDENT_COLLECTION = "Residents";

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public ComplaintDAO(Firestore firestore) {

        if (firestore == null) {
            throw new IllegalArgumentException(
                    "Firestore cannot be null."
            );
        }

        this.firestore = firestore;
    }

    // =========================================================
    // GET RESIDENT SOCIETY
    // =========================================================
    /*
     * Automatically gets society from:
     *
     * Residents/{email}
     *
     * Example:
     *
     * Residents
     *    └── rahul@gmail.com
     *         └── society: "stanza"
     */

    public String getResidentSociety(
            String email)
            throws Exception {

        if (email == null ||
                email.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Resident email cannot be empty."
            );
        }

        String residentEmail =
                email.trim().toLowerCase();

        // =====================================================
        // GET RESIDENT DOCUMENT
        // =====================================================

        DocumentSnapshot residentDocument =
                firestore
                        .collection(RESIDENT_COLLECTION)
                        .document(residentEmail)
                        .get()
                        .get();

        // =====================================================
        // CHECK DOCUMENT
        // =====================================================

        if (!residentDocument.exists()) {

            throw new IllegalArgumentException(
                    "Resident not found: "
                            + residentEmail
            );
        }

        // =====================================================
        // GET SOCIETY
        // =====================================================

        String society =
                residentDocument.getString("society");

        if (society == null ||
                society.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Society not found for resident: "
                            + residentEmail
            );
        }

        society = society.trim();

        // =====================================================
        // DEBUG
        // =====================================================

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "Resident Society Found"
        );

        System.out.println(
                "Resident Email : "
                        + residentEmail
        );

        System.out.println(
                "Society        : "
                        + society
        );

        System.out.println(
                "=========================================="
        );

        return society;
    }

    // =========================================================
    // SAVE COMPLAINT
    // =========================================================

    public void saveComplaint(
            ComplaintModel complaint)
            throws Exception {

        // =====================================================
        // NULL CHECK
        // =====================================================

        if (complaint == null) {

            throw new IllegalArgumentException(
                    "Complaint cannot be null."
            );
        }

        // =====================================================
        // ID CHECK
        // =====================================================

        if (complaint.getId() == null ||
                complaint.getId().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Complaint ID cannot be empty."
            );
        }

        // =====================================================
        // EMAIL CHECK
        // =====================================================

        if (complaint.getEmail() == null ||
                complaint.getEmail().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Complaint email cannot be empty."
            );
        }

        // =====================================================
        // SOCIETY CHECK
        // =====================================================

        if (complaint.getSociety() == null ||
                complaint.getSociety().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Complaint society cannot be empty."
            );
        }

        // =====================================================
        // NORMALIZE EMAIL
        // =====================================================

        String email =
                complaint.getEmail()
                        .trim()
                        .toLowerCase();

        // =====================================================
        // NORMALIZE SOCIETY
        // =====================================================

        complaint.setSociety(
                complaint.getSociety().trim()
        );

        complaint.setEmail(email);

        // =====================================================
        // SAVE
        // =====================================================

        firestore
                .collection(COLLECTION)
                .document(email)
                .collection(SUB_COLLECTION)
                .document(complaint.getId())
                .set(complaint)
                .get();

        // =====================================================
        // DEBUG
        // =====================================================

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "Complaint saved successfully."
        );

        System.out.println(
                "Complaint ID : "
                        + complaint.getId()
        );

        System.out.println(
                "Email        : "
                        + complaint.getEmail()
        );

        System.out.println(
                "Flat Number  : "
                        + complaint.getFlatNumber()
        );

        System.out.println(
                "Society      : "
                        + complaint.getSociety()
        );

        System.out.println(
                "=========================================="
        );
    }

    // =========================================================
    // GET COMPLAINT BY ID
    // =========================================================

    public ComplaintModel getComplaintById(
            String email,
            String id)
            throws Exception {

        if (email == null ||
                email.trim().isEmpty()) {

            return null;
        }

        if (id == null ||
                id.trim().isEmpty()) {

            return null;
        }

        String residentEmail =
                email.trim().toLowerCase();

        String complaintId =
                id.trim();

        // =====================================================
        // GET DOCUMENT
        // =====================================================

        DocumentSnapshot document =
                firestore
                        .collection(COLLECTION)
                        .document(residentEmail)
                        .collection(SUB_COLLECTION)
                        .document(complaintId)
                        .get()
                        .get();

        // =====================================================
        // CHECK EXISTS
        // =====================================================

        if (!document.exists()) {
            return null;
        }

        // =====================================================
        // CONVERT TO MODEL
        // =====================================================

        return document.toObject(
                ComplaintModel.class
        );
    }

    // =========================================================
    // GET ALL COMPLAINTS
    // =========================================================

    public List<ComplaintModel> getAllComplaints()
            throws Exception {

        List<ComplaintModel> complaints =
                new ArrayList<>();

        // =====================================================
        // GET ALL RESIDENT EMAIL DOCUMENTS
        // =====================================================

        QuerySnapshot parentSnapshot =
                firestore
                        .collection(COLLECTION)
                        .get()
                        .get();

        // =====================================================
        // LOOP RESIDENTS
        // =====================================================

        for (DocumentSnapshot parentDocument :
                parentSnapshot.getDocuments()) {

            QuerySnapshot complaintSnapshot =
                    parentDocument
                            .getReference()
                            .collection(SUB_COLLECTION)
                            .get()
                            .get();

            // =================================================
            // LOOP COMPLAINTS
            // =================================================

            for (DocumentSnapshot document :
                    complaintSnapshot.getDocuments()) {

                ComplaintModel complaint =
                        document.toObject(
                                ComplaintModel.class
                        );

                if (complaint != null) {

                    /*
                     * If email is missing from old
                     * documents, get it from parent ID.
                     */

                    if (complaint.getEmail() == null ||
                            complaint.getEmail()
                                    .trim()
                                    .isEmpty()) {

                        complaint.setEmail(
                                parentDocument.getId()
                        );
                    }

                    /*
                     * If complaint ID is missing,
                     * use Firestore document ID.
                     */

                    if (complaint.getId() == null ||
                            complaint.getId()
                                    .trim()
                                    .isEmpty()) {

                        complaint.setId(
                                document.getId()
                        );
                    }

                    complaints.add(complaint);
                }
            }
        }

        // =====================================================
        // DEBUG
        // =====================================================

        System.out.println(
                "Total complaints: "
                        + complaints.size()
        );

        return complaints;
    }

    // =========================================================
    // GET COMPLAINTS BY EMAIL
    // =========================================================

    public List<ComplaintModel> getComplaintsByEmail(
            String email)
            throws Exception {

        List<ComplaintModel> complaints =
                new ArrayList<>();

        if (email == null ||
                email.trim().isEmpty()) {

            return complaints;
        }

        String loggedInEmail =
                email.trim().toLowerCase();

        // =====================================================
        // FETCH USER'S COMPLAINTS
        // =====================================================

        QuerySnapshot snapshot =
                firestore
                        .collection(COLLECTION)
                        .document(loggedInEmail)
                        .collection(SUB_COLLECTION)
                        .get()
                        .get();

        // =====================================================
        // CONVERT DOCUMENTS
        // =====================================================

        for (DocumentSnapshot document :
                snapshot.getDocuments()) {

            ComplaintModel complaint =
                    document.toObject(
                            ComplaintModel.class
                    );

            if (complaint != null) {

                if (complaint.getId() == null ||
                        complaint.getId()
                                .trim()
                                .isEmpty()) {

                    complaint.setId(
                            document.getId()
                    );
                }

                if (complaint.getEmail() == null ||
                        complaint.getEmail()
                                .trim()
                                .isEmpty()) {

                    complaint.setEmail(
                            loggedInEmail
                    );
                }

                complaints.add(complaint);
            }
        }

        // =====================================================
        // DEBUG
        // =====================================================

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "Complaints found for: "
                        + loggedInEmail
        );

        System.out.println(
                "Total complaints: "
                        + complaints.size()
        );

        System.out.println(
                "=========================================="
        );

        return complaints;
    }

    // =========================================================
    // GET COMPLAINTS BY FLAT
    // =========================================================

    public List<ComplaintModel> getComplaintsByFlat(
            String flatNumber)
            throws Exception {

        List<ComplaintModel> complaints =
                new ArrayList<>();

        if (flatNumber == null ||
                flatNumber.trim().isEmpty()) {

            return complaints;
        }

        String flat =
                flatNumber.trim();

        // =====================================================
        // GET ALL EMAIL DOCUMENTS
        // =====================================================

        QuerySnapshot parentSnapshot =
                firestore
                        .collection(COLLECTION)
                        .get()
                        .get();

        // =====================================================
        // LOOP ALL RESIDENTS
        // =====================================================

        for (DocumentSnapshot parentDocument :
                parentSnapshot.getDocuments()) {

            QuerySnapshot snapshot =
                    parentDocument
                            .getReference()
                            .collection(SUB_COLLECTION)
                            .whereEqualTo(
                                    "flatNumber",
                                    flat
                            )
                            .get()
                            .get();

            // =================================================
            // LOOP COMPLAINTS
            // =================================================

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                ComplaintModel complaint =
                        document.toObject(
                                ComplaintModel.class
                        );

                if (complaint != null) {

                    if (complaint.getId() == null ||
                            complaint.getId()
                                    .trim()
                                    .isEmpty()) {

                        complaint.setId(
                                document.getId()
                        );
                    }

                    complaints.add(complaint);
                }
            }
        }

        return complaints;
    }

    // =========================================================
    // GET COMPLAINTS BY SOCIETY
    // =========================================================
    /*
     * Used mainly by Secretary.
     *
     * It fetches only complaints where:
     *
     * society == requested society
     *
     * Example:
     *
     * getComplaintsBySociety("stanza")
     *
     * will return only:
     *
     * society = "stanza"
     */

    public List<ComplaintModel> getComplaintsBySociety(
            String society)
            throws Exception {

        List<ComplaintModel> complaints =
                new ArrayList<>();

        if (society == null ||
                society.trim().isEmpty()) {

            return complaints;
        }

        String requestedSociety =
                society.trim();

        // =====================================================
        // COLLECTION GROUP QUERY
        // =====================================================
        /*
         * Searches every:
         *
         * complaints/{email}/complaints
         *
         * subcollection.
         */

        QuerySnapshot snapshot =
                firestore
                        .collectionGroup(SUB_COLLECTION)
                        .whereEqualTo(
                                "society",
                                requestedSociety
                        )
                        .get()
                        .get();

        // =====================================================
        // CONVERT DOCUMENTS
        // =====================================================

        for (DocumentSnapshot document :
                snapshot.getDocuments()) {

            ComplaintModel complaint =
                    document.toObject(
                            ComplaintModel.class
                    );

            if (complaint != null) {

                if (complaint.getId() == null ||
                        complaint.getId()
                                .trim()
                                .isEmpty()) {

                    complaint.setId(
                            document.getId()
                    );
                }

                complaints.add(complaint);
            }
        }

        // =====================================================
        // DEBUG
        // =====================================================

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "Complaints By Society"
        );

        System.out.println(
                "Society: "
                        + requestedSociety
        );

        System.out.println(
                "Total complaints: "
                        + complaints.size()
        );

        System.out.println(
                "=========================================="
        );

        return complaints;
    }

    // =========================================================
    // UPDATE STATUS
    // =========================================================

    public void updateStatus(
            String email,
            String complaintId,
            String status)
            throws Exception {

        // =====================================================
        // VALIDATION
        // =====================================================

        if (email == null ||
                email.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Email cannot be empty."
            );
        }

        if (complaintId == null ||
                complaintId.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Complaint ID cannot be empty."
            );
        }

        if (status == null ||
                status.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Status cannot be empty."
            );
        }

        String residentEmail =
                email.trim().toLowerCase();

        String id =
                complaintId.trim();

        String newStatus =
                status.trim();

        // =====================================================
        // UPDATE
        // =====================================================

        firestore
                .collection(COLLECTION)
                .document(residentEmail)
                .collection(SUB_COLLECTION)
                .document(id)
                .update(
                        "status",
                        newStatus
                )
                .get();

        // =====================================================
        // DEBUG
        // =====================================================

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "Complaint status updated."
        );

        System.out.println(
                "Email      : "
                        + residentEmail
        );

        System.out.println(
                "ComplaintID: "
                        + id
        );

        System.out.println(
                "New Status : "
                        + newStatus
        );

        System.out.println(
                "=========================================="
        );
    }
}