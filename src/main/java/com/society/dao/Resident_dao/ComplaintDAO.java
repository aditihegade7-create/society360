package com.society.dao.Resident_dao;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.society.model.Resident_model.ComplaintModel;

import java.util.ArrayList;
import java.util.List;

public class ComplaintDAO {

    private final Firestore firestore;

    private static final String COLLECTION = "complaints";

    public ComplaintDAO(Firestore firestore) {
        this.firestore = firestore;
    }

    // ================= SAVE COMPLAINT =================

    public void saveComplaint(ComplaintModel complaint)
            throws Exception {

        firestore
                .collection(COLLECTION)
                .document(complaint.getId())
                .set(complaint)
                .get();
    }

    // ================= GET COMPLAINT BY ID =================

    public ComplaintModel getComplaintById(String id)
            throws Exception {

        DocumentSnapshot document =
                firestore
                        .collection(COLLECTION)
                        .document(id)
                        .get()
                        .get();

        if (!document.exists()) {
            return null;
        }

        return document.toObject(ComplaintModel.class);
    }

    // ================= GET ALL COMPLAINTS =================

    public List<ComplaintModel> getAllComplaints()
            throws Exception {

        QuerySnapshot snapshot =
                firestore
                        .collection(COLLECTION)
                        .get()
                        .get();

        List<ComplaintModel> complaints =
                new ArrayList<>();

        for (DocumentSnapshot document :
                snapshot.getDocuments()) {

            ComplaintModel complaint =
                    document.toObject(ComplaintModel.class);

            if (complaint != null) {
                complaints.add(complaint);
            }
        }

        return complaints;
    }

    // ================= GET COMPLAINTS BY FLAT =================

    public List<ComplaintModel> getComplaintsByFlat(
            String flatNumber)
            throws Exception {

        QuerySnapshot snapshot =
                firestore
                        .collection(COLLECTION)
                        .whereEqualTo(
                                "flatNumber",
                                flatNumber
                        )
                        .get()
                        .get();

        List<ComplaintModel> complaints =
                new ArrayList<>();

        for (DocumentSnapshot document :
                snapshot.getDocuments()) {

            ComplaintModel complaint =
                    document.toObject(ComplaintModel.class);

            if (complaint != null) {
                complaints.add(complaint);
            }
        }

        return complaints;
    }

    // ================= UPDATE STATUS =================

    public void updateStatus(
            String complaintId,
            String status)
            throws Exception {

        firestore
                .collection(COLLECTION)
                .document(complaintId)
                .update("status", status)
                .get();
    }
}


