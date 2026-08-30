package com.society.dao.Resident_dao;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.society.model.Resident_model.VisitorModel;

import java.util.ArrayList;
import java.util.List;

public class VisitorDAO {

    private final Firestore firestore;

    private static final String COLLECTION = "visitors";

    public VisitorDAO(Firestore firestore) {
        this.firestore = firestore;
    }

    // SAVE VISITOR
    public void saveVisitor(VisitorModel visitor) throws Exception {

        firestore
                .collection(COLLECTION)
                .document(visitor.getId())
                .set(visitor)
                .get();
    }

    // GET VISITOR BY ID
    public VisitorModel getVisitorById(String id)
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

        return document.toObject(VisitorModel.class);
    }

    // FIND VISITOR USING QR TOKEN
    public VisitorModel getVisitorByQrToken(String qrToken)
            throws Exception {

        QuerySnapshot snapshot =
                firestore
                        .collection(COLLECTION)
                        .whereEqualTo("qrToken", qrToken)
                        .limit(1)
                        .get()
                        .get();

        if (snapshot.isEmpty()) {
            return null;
        }

        return snapshot
                .getDocuments()
                .get(0)
                .toObject(VisitorModel.class);
    }

    // GET VISITORS FOR A PARTICULAR DATE
    public List<VisitorModel> getVisitorsByDate(String date)
            throws Exception {

        QuerySnapshot snapshot =
                firestore
                        .collection(COLLECTION)
                        .whereEqualTo("visitDate", date)
                        .get()
                        .get();

        List<VisitorModel> visitors =
                new ArrayList<>();

        for (DocumentSnapshot document :
                snapshot.getDocuments()) {

            VisitorModel visitor =
                    document.toObject(
                            VisitorModel.class
                    );

            if (visitor != null) {
                visitors.add(visitor);
            }
        }

        return visitors;
    }

    // MARK VISITOR AS ENTERED
    public void markVisitorAsUsed(String id)
            throws Exception {

        firestore
                .collection(COLLECTION)
                .document(id)
                .update(
                        "used", true,
                        "status", "VISITED"
                )
                .get();
    }
}
