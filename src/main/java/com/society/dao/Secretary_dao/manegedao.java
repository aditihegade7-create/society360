package com.society.dao.Secretary_dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;

import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.Maintenance;

public class manegedao {

    // =========================================================
    // FIRESTORE COLLECTIONS
    // =========================================================

    private static final String MAIN_COLLECTION = "Maintenance";

    private static final String RECORDS_COLLECTION = "records";

    // =========================================================
    // FIRESTORE
    // =========================================================

    private final Firestore firestore;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public manegedao() {

        this.firestore = FirebaseConfig.getFirestore();

        if (this.firestore == null) {
            throw new IllegalStateException(
                    "Firestore initialization failed. "
                    + "FirebaseConfig.getFirestore() returned null."
            );
        }

        System.out.println(
                "MaintenanceDao initialized successfully."
        );
    }

    // =========================================================
    // ADD MAINTENANCE
    // =========================================================
    //
    // IMPORTANT:
    // Maintenance is now stored under SECRETARY EMAIL.
    //
    // Maintenance/{secretaryEmail}/records/{maintenanceId}
    //
    // =========================================================

    public boolean addMaintenance(Maintenance maintenance) {

        try {

            if (maintenance == null) {

                System.err.println(
                        "Maintenance object is null."
                );

                return false;
            }

            // -------------------------------------------------
            // SECRETARY EMAIL
            // -------------------------------------------------

            String secretaryEmail =
                    safeValue(
                            maintenance.getAddedBySecretaryEmail()
                    );

            if (secretaryEmail.isEmpty()) {

                System.err.println(
                        "Secretary email is required."
                );

                return false;
            }

            secretaryEmail =
                    secretaryEmail
                            .trim()
                            .toLowerCase();

            // -------------------------------------------------
            // SOCIETY
            // -------------------------------------------------

            String society =
                    safeValue(
                            maintenance.getSociety()
                    );

            if (society.isEmpty()) {

                System.err.println(
                        "Society is required."
                );

                return false;
            }

            society = society.trim();

            // -------------------------------------------------
            // SECRETARY RECORDS COLLECTION
            // -------------------------------------------------

            CollectionReference records =
                    firestore
                            .collection(MAIN_COLLECTION)
                            .document(secretaryEmail)
                            .collection(RECORDS_COLLECTION);

            // -------------------------------------------------
            // CREATE NEW DOCUMENT
            // -------------------------------------------------

            DocumentReference document =
                    records.document();

            String maintenanceId =
                    document.getId();

            // -------------------------------------------------
            // PREPARE DATA
            // -------------------------------------------------

            Map<String, Object> data =
                    new HashMap<>();

            // -------------------------------------------------
            // MAINTENANCE ID
            // -------------------------------------------------

            data.put(
                    "maintenanceId",
                    maintenanceId
            );

            // -------------------------------------------------
            // AMOUNT
            // -------------------------------------------------

            data.put(
                    "amount",
                    safeValue(
                            maintenance.getAmount()
                    )
            );

            // -------------------------------------------------
            // MONTH
            // -------------------------------------------------

            data.put(
                    "month",
                    safeValue(
                            maintenance.getMonth()
                    )
            );

            // -------------------------------------------------
            // DATE
            // -------------------------------------------------

            data.put(
                    "date",
                    safeValue(
                            maintenance.getDate()
                    )
            );

            // -------------------------------------------------
            // STATUS
            // -------------------------------------------------

            data.put(
                    "status",
                    normalizeStatus(
                            maintenance.getStatus()
                    )
            );

            // -------------------------------------------------
            // SECRETARY EMAIL
            // -------------------------------------------------

            data.put(
                    "addedBySecretaryEmail",
                    secretaryEmail
            );

            // -------------------------------------------------
            // SOCIETY
            // -------------------------------------------------

            data.put(
                    "society",
                    society
            );

            // -------------------------------------------------
            // SAVE DEBUG
            // -------------------------------------------------

            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "SAVING MAINTENANCE"
            );

            System.out.println(
                    "Added By Secretary = "
                            + secretaryEmail
            );

            System.out.println(
                    "Society             = "
                            + society
            );

            System.out.println(
                    "Amount              = "
                            + safeValue(
                                    maintenance.getAmount()
                            )
            );

            System.out.println(
                    "Month               = "
                            + safeValue(
                                    maintenance.getMonth()
                            )
            );

            System.out.println(
                    "Date                = "
                            + safeValue(
                                    maintenance.getDate()
                            )
            );

            System.out.println(
                    "Status              = "
                            + normalizeStatus(
                                    maintenance.getStatus()
                            )
            );

            System.out.println(
                    "Maintenance ID      = "
                            + maintenanceId
            );

            System.out.println(
                    "Firestore Path      = Maintenance/"
                            + secretaryEmail
                            + "/records/"
                            + maintenanceId
            );

            System.out.println(
                    "=========================================="
            );

            // -------------------------------------------------
            // SAVE
            // -------------------------------------------------

            document
                    .set(data)
                    .get();

            System.out.println(
                    "Maintenance added successfully."
            );

            return true;

        } catch (Exception e) {

            System.err.println(
                    "Error while adding maintenance:"
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // GET ALL MAINTENANCE
    // =========================================================
    //
    // Reads:
    //
    // Maintenance/{secretaryEmail}/records/*
    //
    // No collectionGroup query.
    // No Firestore index required.
    //
    // =========================================================

    public List<Maintenance> getAllMaintenance() {

        List<Maintenance> maintenanceList =
                new ArrayList<>();

        try {

            CollectionReference mainCollection =
                    firestore.collection(
                            MAIN_COLLECTION
                    );

            ApiFuture<QuerySnapshot> future =
                    mainCollection.get();

            QuerySnapshot secretarySnapshot =
                    future.get();

            System.out.println(
                    "Maintenance secretary documents = "
                            + secretarySnapshot.size()
            );

            // -------------------------------------------------
            // LOOP SECRETARY DOCUMENTS
            // -------------------------------------------------

            for (DocumentSnapshot secretaryDocument :
                    secretarySnapshot.getDocuments()) {

                if (secretaryDocument == null ||
                        !secretaryDocument.exists()) {

                    continue;
                }

                String secretaryEmail =
                        secretaryDocument.getId();

                if (secretaryEmail == null ||
                        secretaryEmail.trim().isEmpty()) {

                    continue;
                }

                secretaryEmail =
                        secretaryEmail
                                .trim()
                                .toLowerCase();

                // -------------------------------------------------
                // RECORDS
                // -------------------------------------------------

                CollectionReference records =
                        secretaryDocument
                                .getReference()
                                .collection(
                                        RECORDS_COLLECTION
                                );

                QuerySnapshot recordSnapshot =
                        records.get().get();

                System.out.println(
                        "Secretary Email = "
                                + secretaryEmail
                                + " | Records = "
                                + recordSnapshot.size()
                );

                // -------------------------------------------------
                // LOOP RECORDS
                // -------------------------------------------------

                for (DocumentSnapshot document :
                        recordSnapshot.getDocuments()) {

                    if (document == null ||
                            !document.exists()) {

                        continue;
                    }

                    Maintenance maintenance =
                            documentToMaintenance(
                                    document,
                                    secretaryEmail
                            );

                    if (maintenance != null) {

                        maintenanceList.add(
                                maintenance
                        );
                    }
                }
            }

            System.out.println(
                    "Total maintenance fetched = "
                            + maintenanceList.size()
            );

        } catch (Exception e) {

            System.err.println(
                    "Error while fetching all maintenance:"
            );

            e.printStackTrace();
        }

        return maintenanceList;
    }

    // =========================================================
    // GET MAINTENANCE BY SECRETARY EMAIL
    // =========================================================

    public List<Maintenance> getMaintenanceBySecretaryEmail(
            String secretaryEmail) {

        List<Maintenance> list =
                new ArrayList<>();

        try {

            if (secretaryEmail == null ||
                    secretaryEmail.trim().isEmpty()) {

                System.err.println(
                        "Secretary email is empty."
                );

                return list;
            }

            secretaryEmail =
                    secretaryEmail
                            .trim()
                            .toLowerCase();

            CollectionReference records =
                    firestore
                            .collection(MAIN_COLLECTION)
                            .document(secretaryEmail)
                            .collection(RECORDS_COLLECTION);

            QuerySnapshot snapshot =
                    records.get().get();

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                if (document == null ||
                        !document.exists()) {

                    continue;
                }

                Maintenance maintenance =
                        documentToMaintenance(
                                document,
                                secretaryEmail
                        );

                if (maintenance != null) {

                    list.add(maintenance);
                }
            }

            System.out.println(
                    "Maintenance for Secretary "
                            + secretaryEmail
                            + " = "
                            + list.size()
            );

        } catch (Exception e) {

            System.err.println(
                    "Error while fetching maintenance by secretary:"
            );

            e.printStackTrace();
        }

        return list;
    }

    // =========================================================
    // UPDATE STATUS
    // =========================================================
    //
    // Now update path is:
    //
    // Maintenance/{secretaryEmail}/records/{maintenanceId}
    //
    // =========================================================

    public boolean updateMaintenanceStatus(
            String secretaryEmail,
            String maintenanceId,
            String newStatus) {

        try {

            if (secretaryEmail == null ||
                    secretaryEmail.trim().isEmpty()) {

                System.err.println(
                        "Secretary email is empty."
                );

                return false;
            }

            if (maintenanceId == null ||
                    maintenanceId.trim().isEmpty()) {

                System.err.println(
                        "Maintenance ID is empty."
                );

                return false;
            }

            if (newStatus == null ||
                    newStatus.trim().isEmpty()) {

                System.err.println(
                        "New status is empty."
                );

                return false;
            }

            secretaryEmail =
                    secretaryEmail
                            .trim()
                            .toLowerCase();

            maintenanceId =
                    maintenanceId.trim();

            newStatus =
                    normalizeStatus(
                            newStatus
                    );

            DocumentReference ref =
                    firestore
                            .collection(MAIN_COLLECTION)
                            .document(secretaryEmail)
                            .collection(RECORDS_COLLECTION)
                            .document(maintenanceId);

            DocumentSnapshot snapshot =
                    ref.get().get();

            if (!snapshot.exists()) {

                System.err.println(
                        "Maintenance record not found."
                );

                return false;
            }

            ref.update(
                    "status",
                    newStatus
            ).get();

            System.out.println(
                    "Maintenance status updated successfully."
            );

            System.out.println(
                    "Secretary Email = "
                            + secretaryEmail
            );

            System.out.println(
                    "Maintenance ID = "
                            + maintenanceId
            );

            System.out.println(
                    "New Status = "
                            + newStatus
            );

            return true;

        } catch (Exception e) {

            System.err.println(
                    "Error while updating maintenance status:"
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // GET ONE MAINTENANCE
    // =========================================================

    public Maintenance getMaintenance(
            String secretaryEmail,
            String maintenanceId) {

        try {

            if (secretaryEmail == null ||
                    secretaryEmail.trim().isEmpty()) {

                return null;
            }

            if (maintenanceId == null ||
                    maintenanceId.trim().isEmpty()) {

                return null;
            }

            secretaryEmail =
                    secretaryEmail
                            .trim()
                            .toLowerCase();

            maintenanceId =
                    maintenanceId.trim();

            DocumentSnapshot document =
                    firestore
                            .collection(MAIN_COLLECTION)
                            .document(secretaryEmail)
                            .collection(RECORDS_COLLECTION)
                            .document(maintenanceId)
                            .get()
                            .get();

            if (!document.exists()) {

                System.err.println(
                        "Maintenance not found."
                );

                return null;
            }

            return documentToMaintenance(
                    document,
                    secretaryEmail
            );

        } catch (Exception e) {

            System.err.println(
                    "Error while getting maintenance:"
            );

            e.printStackTrace();

            return null;
        }
    }

    // =========================================================
    // DOCUMENT -> MAINTENANCE
    // =========================================================

    private Maintenance documentToMaintenance(
            DocumentSnapshot document,
            String secretaryEmail) {

        try {

            if (document == null ||
                    !document.exists()) {

                return null;
            }

            String amount =
                    getString(
                            document,
                            "amount"
                    );

            String month =
                    getString(
                            document,
                            "month"
                    );

            String date =
                    getString(
                            document,
                            "date"
                    );

            String status =
                    normalizeStatus(
                            getString(
                                    document,
                                    "status"
                            )
                    );

            String addedBySecretaryEmail =
                    getString(
                            document,
                            "addedBySecretaryEmail"
                    );

            if (addedBySecretaryEmail.isEmpty()) {

                addedBySecretaryEmail =
                        secretaryEmail;
            }

            addedBySecretaryEmail =
                    addedBySecretaryEmail
                            .trim()
                            .toLowerCase();

            String society =
                    getString(
                            document,
                            "society"
                    );

            String maintenanceId =
                    getString(
                            document,
                            "maintenanceId"
                    );

            // -------------------------------------------------
            // NEW MODEL
            //
            // No resident email/name/flat required.
            // -------------------------------------------------

            return new Maintenance(
                    "",
                    "",
                    "",
                    amount,
                    month,
                    date,
                    status,
                    addedBySecretaryEmail,
                    society
            );

        } catch (Exception e) {

            System.err.println(
                    "Error converting Firestore document "
                            + "to Maintenance:"
            );

            e.printStackTrace();

            return null;
        }
    }

    // =========================================================
    // GET STRING
    // =========================================================

    private String getString(
            DocumentSnapshot document,
            String field) {

        try {

            if (document == null ||
                    field == null ||
                    field.trim().isEmpty()) {

                return "";
            }

            Object value =
                    document.get(field);

            if (value == null) {

                return "";
            }

            return String.valueOf(value).trim();

        } catch (Exception e) {

            return "";
        }
    }

    // =========================================================
    // SAFE VALUE
    // =========================================================

    private String safeValue(
            String value) {

        if (value == null) {
            return "";
        }

        return value.trim();
    }

    // =========================================================
    // NORMALIZE STATUS
    // =========================================================

    private String normalizeStatus(
            String status) {

        if (status == null ||
                status.trim().isEmpty()) {

            return "Pending";
        }

        String value =
                status.trim();

        if (value.equalsIgnoreCase("pending")) {
            return "Pending";
        }

        if (value.equalsIgnoreCase("paid")) {
            return "Paid";
        }

        if (value.equalsIgnoreCase("overdue")) {
            return "Overdue";
        }

        if (value.equalsIgnoreCase("open")) {
            return "Pending";
        }

        if (value.equalsIgnoreCase("in progress")) {
            return "In Progress";
        }

        return value;
    }
}