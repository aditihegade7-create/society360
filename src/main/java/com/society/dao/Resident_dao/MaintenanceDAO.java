package com.society.dao.Resident_dao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;

import com.society.config.FirebaseConfig;

import java.util.Map;

public class MaintenanceDAO {

    private final Firestore db;

    // Constructor
    public MaintenanceDAO() {
        db = FirebaseConfig.getFirestore();
    }

    // =========================================================
    // GET MAINTENANCE BY EMAIL
    // =========================================================
    public Map<String, Object> getMaintenanceByEmail(String email) {

        try {

            /*
             * Firestore structure:
             *
             * Maintenance
             *      |
             *      └── vaishnavi@gmail.com
             *
             * So we use email as the document ID.
             */

            ApiFuture<DocumentSnapshot> future = db
                    .collection("Maintenance")
                    .document(email)
                    .get();

            DocumentSnapshot document = future.get();

            if (document.exists()) {

                return document.getData();

            } else {

                System.out.println(
                        "No maintenance record found for: " + email);

            }

        } catch (Exception e) {

            System.out.println(
                    "Error fetching maintenance:");

            e.printStackTrace();
        }

        return null;
    }
}