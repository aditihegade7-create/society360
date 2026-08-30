package com.society.dao.Secretary_dao;

import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.Maintenance;

public class MaintenanceDao {

    private Firestore firestore;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public MaintenanceDao() {

        firestore = FirebaseConfig.getFirestore();
    }

    // =====================================================
    // ADD MAINTENANCE
    // =====================================================

    public boolean addMaintenance(Maintenance maintenance) {

        try {

            // =================================================
            // CHECK MAINTENANCE OBJECT
            // =================================================

            if (maintenance == null) {

                System.out.println(
                        "Maintenance object is null."
                );

                return false;
            }

            // =================================================
            // GET EMAIL
            // =================================================

            String email = maintenance.getEmail();

            if (email == null || email.trim().isEmpty()) {

                System.out.println(
                        "Email is required."
                );

                return false;
            }

            email = email.trim();

            // =================================================
            // STORE IN FIRESTORE
            // EMAIL = DOCUMENT ID
            // =================================================

            firestore.collection("Maintenance")
                    .document(email)
                    .set(maintenance)
                    .get();

            System.out.println(
                    "Maintenance added successfully!"
            );

            System.out.println(
                    "Maintenance Document ID = "
                            + email
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error while adding maintenance:"
            );

            e.printStackTrace();

            return false;
        }
    }

    // =====================================================
    // GET ALL MAINTENANCE
    // =====================================================

    public List<Maintenance> getAllMaintenance() {

        List<Maintenance> maintenanceList =
                new ArrayList<>();

        try {

            ApiFuture<QuerySnapshot> future =
                    firestore
                            .collection("Maintenance")
                            .get();

            QuerySnapshot snapshot =
                    future.get();

            // =================================================
            // LOOP THROUGH DOCUMENTS
            // =================================================

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                Maintenance maintenance =
                        document.toObject(
                                Maintenance.class
                        );

                if (maintenance != null) {

                    // =========================================
                    // SET DOCUMENT ID AS EMAIL
                    // =========================================

                    maintenance.setEmail(
                            document.getId()
                    );

                    maintenanceList.add(
                            maintenance
                    );
                }
            }

            System.out.println(
                    "Maintenance fetched: "
                            + maintenanceList.size()
            );

        } catch (Exception e) {

            System.out.println(
                    "Error while fetching maintenance:"
            );

            e.printStackTrace();
        }

        return maintenanceList;
    }
}