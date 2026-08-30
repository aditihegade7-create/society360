package com.society.dao.Secretary_dao;

import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.Notice;

public class NoticeDao {

    private Firestore firestore;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public NoticeDao() {

        firestore = FirebaseConfig.getFirestore();
    }

    // =====================================================
    // ADD NOTICE
    // =====================================================

    public boolean addNotice(Notice notice) {

        try {

            firestore.collection("Notices")
                    .add(notice)
                    .get();

            System.out.println(
                    "Notice added successfully!"
            );

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    // =====================================================
    // GET ALL NOTICES
    // =====================================================

    public List<Notice> getAllNotices() {

        List<Notice> notices =
                new ArrayList<>();

        try {

            ApiFuture<QuerySnapshot> future =
                    firestore.collection("Notices")
                            .get();

            QuerySnapshot snapshot =
                    future.get();

            // =================================================
            // LOOP THROUGH FIRESTORE DOCUMENTS
            // =================================================

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                Notice notice =
                        document.toObject(
                                Notice.class
                        );

                if (notice != null) {

                    notices.add(notice);
                }
            }

            System.out.println(
                    "Notices fetched: "
                    + notices.size()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        return notices;
    }
}