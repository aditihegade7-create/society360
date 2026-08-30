package com.society.dao.Secretary_dao;

import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.DashboardData;

/**
 * DashboardDao
 *
 * Combined DAO for Secretary Dashboard.
 *
 * Firestore Collections:
 *
 * Residents
 * Owners
 * Guards
 * Complaints
 * Maintenance
 */
public class DashboardDao {

    // ============================================================
    // FIRESTORE
    // ============================================================

    private Firestore firestore;

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public DashboardDao() {

        firestore = FirebaseConfig.getFirestore();

        System.out.println(
                "DashboardDao: Firestore connected."
        );
    }

    // ============================================================
    // GET DASHBOARD DATA
    // ============================================================

    public DashboardData getDashboardData() {

        try {

            System.out.println(
                    "DashboardDao: Fetching dashboard data..."
            );

            // ====================================================
            // RESIDENTS
            // ====================================================

            int totalResidents =
                    getCollectionCount("Residents");

            // ====================================================
            // OWNERS
            // ====================================================

            int totalOwners =
                    getCollectionCount("Owners");

            // ====================================================
            // GUARDS
            // ====================================================

            int totalGuards =
                    getCollectionCount("Guards");

            // ====================================================
            // OPEN COMPLAINTS
            // ====================================================

            int openComplaints =
                    getOpenComplaints();

            // ====================================================
            // MAINTENANCE COLLECTION
            // ====================================================

            double maintenanceCollection =
                    getMaintenanceCollection();

            // ====================================================
            // CREATE DASHBOARD MODEL
            // ====================================================

            DashboardData dashboardData =
                    new DashboardData(
                            totalResidents,
                            totalOwners,
                            totalGuards,
                            openComplaints,
                            maintenanceCollection
                    );

            // ====================================================
            // PRINT DATA
            // ====================================================

            System.out.println(
                    "----------------------------------------"
            );

            System.out.println(
                    "Residents: " + totalResidents
            );

            System.out.println(
                    "Owners: " + totalOwners
            );

            System.out.println(
                    "Guards: " + totalGuards
            );

            System.out.println(
                    "Open Complaints: " + openComplaints
            );

            System.out.println(
                    "Maintenance Collection: ₹"
                            + maintenanceCollection
            );

            System.out.println(
                    "----------------------------------------"
            );

            return dashboardData;

        } catch (Exception e) {

            System.out.println(
                    "DashboardDao Error: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return null;
        }
    }

    // ============================================================
    // GET COLLECTION COUNT
    // ============================================================

    private int getCollectionCount(
            String collectionName) {

        try {

            ApiFuture<QuerySnapshot> future =
                    firestore
                            .collection(collectionName)
                            .get();

            QuerySnapshot snapshot =
                    future.get();

            return snapshot.size();

        } catch (Exception e) {

            System.out.println(
                    "Error fetching "
                            + collectionName
                            + " count: "
                            + e.getMessage()
            );

            return 0;
        }
    }

    // ============================================================
    // GET OPEN COMPLAINTS
    // ============================================================

    private int getOpenComplaints() {

        try {

            Query query =
                    firestore
                            .collection("Complaints")
                            .whereEqualTo(
                                    "status",
                                    "Open"
                            );

            ApiFuture<QuerySnapshot> future =
                    query.get();

            QuerySnapshot snapshot =
                    future.get();

            return snapshot.size();

        } catch (Exception e) {

            System.out.println(
                    "Error fetching open complaints: "
                            + e.getMessage()
            );

            return 0;
        }
    }

    // ============================================================
    // GET MAINTENANCE COLLECTION
    // ============================================================

    private double getMaintenanceCollection() {

        double totalAmount = 0.0;

        try {

            ApiFuture<QuerySnapshot> future =
                    firestore
                            .collection("Maintenance")
                            .get();

            QuerySnapshot snapshot =
                    future.get();

            List<QueryDocumentSnapshot> documents =
                    snapshot.getDocuments();

            // ====================================================
            // LOOP THROUGH MAINTENANCE DOCUMENTS
            // ====================================================

            for (DocumentSnapshot document :
                    documents) {

                Object amountObject =
                        document.get("amount");

                if (amountObject == null) {

                    continue;
                }

                // =================================================
                // NUMBER
                // =================================================

                if (amountObject instanceof Number) {

                    totalAmount +=
                            ((Number) amountObject)
                                    .doubleValue();

                }

                // =================================================
                // STRING
                // =================================================

                else if (amountObject instanceof String) {

                    String amountString =
                            (String) amountObject;

                    // Remove ₹ and commas
                    amountString =
                            amountString
                                    .replace("₹", "")
                                    .replace(",", "")
                                    .trim();

                    try {

                        totalAmount +=
                                Double.parseDouble(
                                        amountString
                                );

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Invalid maintenance amount: "
                                        + amountString
                        );
                    }
                }
            }

            return totalAmount;

        } catch (Exception e) {

            System.out.println(
                    "Error fetching maintenance: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return 0.0;
        }
    }
}