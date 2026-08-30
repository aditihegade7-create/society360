package com.society.dao.Secretary_dao;

import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.Guard;

public class GuardDaoImpl implements GuardDao {

    private Firestore firestore;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public GuardDaoImpl() {

        firestore =
                FirebaseConfig.getFirestore();
    }

    // =====================================================
    // ADD GUARD
    // =====================================================

    @Override
    public boolean addGuard(Guard guard) {

        try {

            firestore
                    .collection("Guards")
                    .add(guard)
                    .get();

            System.out.println(
                    "Guard added successfully!"
            );

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    // =====================================================
    // FETCH ALL GUARDS
    // =====================================================

    @Override
    public List<Guard> getAllGuards() {

        List<Guard> guards =
                new ArrayList<>();

        try {

            ApiFuture<QuerySnapshot> future =
                    firestore
                            .collection("Guards")
                            .get();

            QuerySnapshot snapshot =
                    future.get();

            // =================================================
            // LOOP THROUGH DOCUMENTS
            // =================================================

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                Guard guard =
                        document.toObject(
                                Guard.class
                        );

                if (guard != null) {

                    // =================================================
                    // VERY IMPORTANT
                    // FIRESTORE DOCUMENT ID
                    // =================================================

                    guard.setId(
                            document.getId()
                    );

                    guards.add(guard);
                }
            }

            System.out.println(
                    "Guards fetched: "
                    + guards.size()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        return guards;
    }

    // =====================================================
    // UPDATE GUARD
    // =====================================================

    @Override
    public boolean updateGuard(
            String id,
            String shift,
            String status,
            String assignedGate) {

        try {

            // =================================================
            // VALIDATE ID
            // =================================================

            if (id == null ||
                    id.trim().isEmpty()) {

                System.out.println(
                        "Guard ID is empty."
                );

                return false;
            }

            // =================================================
            // UPDATE DATA
            // =================================================

            firestore
                    .collection("Guards")
                    .document(id)
                    .update(
                            "shift",
                            shift,

                            "status",
                            status,

                            "assignedGate",
                            assignedGate
                    )
                    .get();

            System.out.println(
                    "Guard updated successfully!"
            );

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}