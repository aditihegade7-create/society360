package com.society.dao.Resident_dao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.society.model.Resident_model.Maintenance;
import com.society.config.FirebaseConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MaintenanceDAO {

    private final Firestore db;

    private static final String RESIDENT_COLLECTION = "residents";
    private static final String MAINTENANCE_COLLECTION = "maintenance";

    public MaintenanceDAO() {
        db = FirebaseConfig.getFirestore();
    }

    // =========================================================
    // GET FLAT NUMBER USING EMAIL
    // =========================================================

    public String getFlatNoByEmail(String email) {

        try {

            ApiFuture<QuerySnapshot> future = db
                    .collection(RESIDENT_COLLECTION)
                    .whereEqualTo("email", email)
                    .limit(1)
                    .get();

            QuerySnapshot snapshot = future.get();

            if (snapshot.isEmpty()) {

                System.out.println("ERROR: Resident not found for email: " + email);

                return null;
            }

            DocumentSnapshot document = snapshot.getDocuments().get(0);

            String flatNo = document.getString("flatNo");

            System.out.println("Logged in email: " + email);
            System.out.println("Logged in Flat No: " + flatNo);

            return flatNo;

        } catch (Exception e) {

            System.out.println("Error getting flat number: " + e.getMessage());

            e.printStackTrace();

            return null;
        }
    }

    // =========================================================
    // GET ALL MAINTENANCE FOR FLAT
    // =========================================================

    public List<Maintenance> getMaintenanceByFlatNo(String flatNo) {

        List<Maintenance> maintenanceList = new ArrayList<>();

        if (flatNo == null || flatNo.trim().isEmpty()) {

            System.out.println("ERROR: Flat number is null or empty!");

            return maintenanceList;
        }

        try {

            ApiFuture<QuerySnapshot> future = db
                    .collection(MAINTENANCE_COLLECTION)
                    .whereEqualTo("flatNo", flatNo)
                    .get();

            QuerySnapshot snapshot = future.get();

            System.out.println("=================================");
            System.out.println("Fetching maintenance for: " + flatNo);
            System.out.println("Records found: " + snapshot.size());
            System.out.println("=================================");

            for (DocumentSnapshot document : snapshot.getDocuments()) {

                Maintenance maintenance = new Maintenance();

                maintenance.setDocumentId(document.getId());

                maintenance.setAmount(
                        document.getString("amount")
                );

                maintenance.setDate(
                        document.getString("date")
                );

                maintenance.setFlatNo(
                        document.getString("flatNo")
                );

                maintenance.setMonth(
                        document.getString("month")
                );

                maintenance.setResidentName(
                        document.getString("residentName")
                );

                maintenance.setStatus(
                        document.getString("status")
                );

                maintenanceList.add(maintenance);
            }

        } catch (InterruptedException | ExecutionException e) {

            System.out.println(
                    "Error fetching maintenance: "
                            + e.getMessage()
            );

            e.printStackTrace();
        }

        return maintenanceList;
    }

    // =========================================================
    // UPDATE BILL STATUS TO PAID
    // =========================================================

    public boolean markAsPaid(String documentId) {

        if (documentId == null || documentId.isEmpty()) {
            return false;
        }

        try {

            db.collection(MAINTENANCE_COLLECTION)
                    .document(documentId)
                    .update("status", "Paid")
                    .get();

            System.out.println(
                    "Payment successful. Bill marked as Paid."
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Payment error: " + e.getMessage()
            );

            e.printStackTrace();

            return false;
        }
    }
}