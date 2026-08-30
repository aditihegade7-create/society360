package com.society.dao.Secretary_dao;

import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.Resident;

public class ResidentDaoImpl implements ResidentDao {

    private Firestore firestore;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public ResidentDaoImpl() {

        firestore = FirebaseConfig.getFirestore();
    }

    // =====================================================
    // ADD RESIDENT
    // =====================================================

    @Override
    public boolean addResident(Resident resident) {

        try {

            firestore.collection("Residents")
                    .add(resident)
                    .get();

            System.out.println(
                    "Resident added successfully!"
            );

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    // =====================================================
    // FETCH ALL RESIDENTS
    // =====================================================

    @Override
    public List<Resident> getAllResidents() {

        List<Resident> residents =
                new ArrayList<>();

        try {

            // IMPORTANT:
            // Same collection name used while saving

            ApiFuture<QuerySnapshot> future =
                    firestore.collection("Residents")
                            .get();

            QuerySnapshot snapshot =
                    future.get();

            // =================================================
            // LOOP THROUGH FIRESTORE DOCUMENTS
            // =================================================

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                Resident resident =
                        document.toObject(
                                Resident.class
                        );

                if (resident != null) {

                    residents.add(resident);
                }
            }

            System.out.println(
                    "Residents fetched: "
                    + residents.size()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        return residents;
    }
}