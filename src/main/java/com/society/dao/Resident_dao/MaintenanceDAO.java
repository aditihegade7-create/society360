package com.society.dao.Resident_dao;

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

public class MaintenanceDAO {

    // =========================================================
    // FIRESTORE
    // =========================================================

    private final Firestore firestore;

    private static final String MAINTENANCE_COLLECTION =
            "Maintenance";

    private static final String RECORDS_COLLECTION =
            "records";

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public MaintenanceDAO() {

        firestore = FirebaseConfig.getFirestore();

        if (firestore == null) {

            throw new IllegalStateException(
                    "Firestore initialization failed."
            );
        }
    }

    // =========================================================
    // ADD MAINTENANCE
    // =========================================================
    //
    // Firestore:
    //
    // Maintenance
    //     └── secretaryEmail
    //           └── records
    //                 └── maintenanceId
    //
    // =========================================================

    public boolean addMaintenance(Maintenance maintenance) {

        try {

            // -------------------------------------------------
            // VALIDATE OBJECT
            // -------------------------------------------------

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
                    cleanEmail(
                            maintenance.getAddedBySecretaryEmail()
                    );

            if (secretaryEmail.isEmpty()) {

                System.err.println(
                        "Secretary email is missing."
                );

                return false;
            }

            // -------------------------------------------------
            // SOCIETY
            // -------------------------------------------------

            String society =
                    clean(
                            maintenance.getSociety()
                    );

            if (society.isEmpty()) {

                System.err.println(
                        "Society is missing."
                );

                return false;
            }

            // -------------------------------------------------
            // AMOUNT
            // -------------------------------------------------

            String amount =
                    clean(
                            maintenance.getAmount()
                    );

            if (amount.isEmpty()) {

                System.err.println(
                        "Maintenance amount is missing."
                );

                return false;
            }

            // -------------------------------------------------
            // MONTH
            // -------------------------------------------------

            String month =
                    clean(
                            maintenance.getMonth()
                    );

            if (month.isEmpty()) {

                System.err.println(
                        "Maintenance month is missing."
                );

                return false;
            }

            // -------------------------------------------------
            // DATE
            // -------------------------------------------------

            String date =
                    clean(
                            maintenance.getDate()
                    );

            if (date.isEmpty()) {

                System.err.println(
                        "Maintenance date is missing."
                );

                return false;
            }

            // -------------------------------------------------
            // STATUS
            // -------------------------------------------------

            String status =
                    normalizeStatus(
                            maintenance.getStatus()
                    );

            if (status.isEmpty()) {

                status = "Pending";
            }

            // -------------------------------------------------
            // CREATE DOCUMENT REFERENCE
            // -------------------------------------------------

            DocumentReference recordReference =
                    firestore
                            .collection(
                                    MAINTENANCE_COLLECTION
                            )
                            .document(
                                    secretaryEmail
                            )
                            .collection(
                                    RECORDS_COLLECTION
                            )
                            .document();

            // -------------------------------------------------
            // GENERATED MAINTENANCE ID
            // -------------------------------------------------

            String maintenanceId =
                    recordReference.getId();

            // -------------------------------------------------
            // FIRESTORE DATA
            // -------------------------------------------------

            Map<String, Object> data =
                    new HashMap<>();

            data.put(
                    "maintenanceId",
                    maintenanceId
            );

            data.put(
                    "amount",
                    amount
            );

            data.put(
                    "month",
                    month
            );

            data.put(
                    "date",
                    date
            );

            data.put(
                    "status",
                    status
            );

            data.put(
                    "addedBySecretaryEmail",
                    secretaryEmail
            );

            data.put(
                    "society",
                    society
            );

            // -------------------------------------------------
            // SAVE
            // -------------------------------------------------

            recordReference
                    .set(data)
                    .get();

            // -------------------------------------------------
            // SUCCESS LOG
            // -------------------------------------------------

            System.out.println(
                    "\n=============================================="
            );

            System.out.println(
                    "MAINTENANCE SAVED SUCCESSFULLY"
            );

            System.out.println(
                    "Path: Maintenance/"
                            + secretaryEmail
                            + "/records/"
                            + maintenanceId
            );

            System.out.println(
                    "Secretary Email : "
                            + secretaryEmail
            );

            System.out.println(
                    "Maintenance ID  : "
                            + maintenanceId
            );

            System.out.println(
                    "Society         : "
                            + society
            );

            System.out.println(
                    "Amount          : "
                            + amount
            );

            System.out.println(
                    "Month           : "
                            + month
            );

            System.out.println(
                    "Date            : "
                            + date
            );

            System.out.println(
                    "Status          : "
                            + status
            );

            System.out.println(
                    "==============================================\n"
            );

            return true;

        } catch (Exception e) {

            System.err.println(
                    "=============================================="
            );

            System.err.println(
                    "ERROR WHILE ADDING MAINTENANCE"
            );

            System.err.println(
                    "=============================================="
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // GET ALL MAINTENANCE
    // =========================================================
    //
    // This method reads:
    //
    // Maintenance
    //     └── ALL secretary documents
    //           └── records
    //
    // Controller can then filter by society.
    //
    // =========================================================

    public List<Maintenance> getAllMaintenance() {

        List<Maintenance> result =
                new ArrayList<>();

        try {

            System.out.println(
                    "\n=============================================="
            );

            System.out.println(
                    "FETCHING ALL MAINTENANCE FROM FIRESTORE"
            );

            System.out.println(
                    "=============================================="
            );

            // -------------------------------------------------
            // GET ALL SECRETARY DOCUMENTS
            // -------------------------------------------------

            ApiFuture<QuerySnapshot> future =
                    firestore
                            .collection(
                                    MAINTENANCE_COLLECTION
                            )
                            .get();

            QuerySnapshot secretarySnapshot =
                    future.get();

            System.out.println(
                    "Maintenance secretary documents = "
                            + secretarySnapshot.size()
            );

            // -------------------------------------------------
            // LOOP SECRETARY DOCUMENTS
            // -------------------------------------------------

            for (
                    DocumentSnapshot secretaryDocument :
                    secretarySnapshot.getDocuments()
            ) {

                if (
                        secretaryDocument == null ||
                        !secretaryDocument.exists()
                ) {
                    continue;
                }

                String secretaryEmail =
                        cleanEmail(
                                secretaryDocument.getId()
                        );

                if (secretaryEmail.isEmpty()) {
                    continue;
                }

                // -------------------------------------------------
                // RECORDS COLLECTION
                // -------------------------------------------------

                CollectionReference recordsCollection =
                        secretaryDocument
                                .getReference()
                                .collection(
                                        RECORDS_COLLECTION
                                );

                QuerySnapshot recordsSnapshot =
                        recordsCollection
                                .get()
                                .get();

                System.out.println(
                        "Secretary Email = "
                                + secretaryEmail
                                + " | Records = "
                                + recordsSnapshot.size()
                );

                // -------------------------------------------------
                // LOOP RECORDS
                // -------------------------------------------------

                for (
                        DocumentSnapshot record :
                        recordsSnapshot.getDocuments()
                ) {

                    if (
                            record == null ||
                            !record.exists()
                    ) {
                        continue;
                    }

                    Maintenance maintenance =
                            documentToMaintenance(
                                    record,
                                    secretaryEmail
                            );

                    if (maintenance != null) {

                        result.add(
                                maintenance
                        );
                    }
                }
            }

            System.out.println(
                    "Total maintenance fetched = "
                            + result.size()
            );

            System.out.println(
                    "==============================================\n"
            );

        } catch (Exception e) {

            System.err.println(
                    "Error while fetching all maintenance:"
            );

            e.printStackTrace();
        }

        return result;
    }

    // =========================================================
    // GET MAINTENANCE BY SECRETARY EMAIL
    // =========================================================
    //
    // This is the recommended method for Secretary UI.
    //
    // Reads only:
    //
    // Maintenance
    //     └── currentSecretaryEmail
    //           └── records
    //
    // =========================================================

    public List<Maintenance> getAllMaintenanceBySecretaryEmail(
            String secretaryEmail) {

        List<Maintenance> result =
                new ArrayList<>();

        try {

            secretaryEmail =
                    cleanEmail(secretaryEmail);

            if (secretaryEmail.isEmpty()) {

                System.err.println(
                        "Secretary email is empty."
                );

                return result;
            }

            System.out.println(
                    "\n=============================================="
            );

            System.out.println(
                    "FETCHING MAINTENANCE BY SECRETARY EMAIL"
            );

            System.out.println(
                    "Secretary Email = "
                            + secretaryEmail
            );

            System.out.println(
                    "=============================================="
            );

            // -------------------------------------------------
            // RECORDS COLLECTION
            // -------------------------------------------------

            CollectionReference recordsCollection =
                    firestore
                            .collection(
                                    MAINTENANCE_COLLECTION
                            )
                            .document(
                                    secretaryEmail
                            )
                            .collection(
                                    RECORDS_COLLECTION
                            );

            // -------------------------------------------------
            // GET RECORDS
            // -------------------------------------------------

            QuerySnapshot snapshot =
                    recordsCollection
                            .get()
                            .get();

            System.out.println(
                    "Records found = "
                            + snapshot.size()
            );

            // -------------------------------------------------
            // LOOP RECORDS
            // -------------------------------------------------

            for (
                    DocumentSnapshot document :
                    snapshot.getDocuments()
            ) {

                if (
                        document == null ||
                        !document.exists()
                ) {
                    continue;
                }

                Maintenance maintenance =
                        documentToMaintenance(
                                document,
                                secretaryEmail
                        );

                if (maintenance != null) {

                    result.add(
                            maintenance
                    );
                }
            }

            System.out.println(
                    "Total maintenance for "
                            + secretaryEmail
                            + " = "
                            + result.size()
            );

            System.out.println(
                    "==============================================\n"
            );

        } catch (Exception e) {

            System.err.println(
                    "Error fetching maintenance by secretary email:"
            );

            e.printStackTrace();
        }

        return result;
    }

    // =========================================================
    // GET MAINTENANCE BY ID
    // =========================================================
    //
    // Reads:
    //
    // Maintenance/{secretaryEmail}/records/{maintenanceId}
    //
    // =========================================================

    public Maintenance getMaintenanceById(
            String secretaryEmail,
            String maintenanceId) {

        try {

            secretaryEmail =
                    cleanEmail(secretaryEmail);

            maintenanceId =
                    clean(maintenanceId);

            if (
                    secretaryEmail.isEmpty() ||
                    maintenanceId.isEmpty()
            ) {
                return null;
            }

            DocumentReference reference =
                    firestore
                            .collection(
                                    MAINTENANCE_COLLECTION
                            )
                            .document(
                                    secretaryEmail
                            )
                            .collection(
                                    RECORDS_COLLECTION
                            )
                            .document(
                                    maintenanceId
                            );

            DocumentSnapshot snapshot =
                    reference
                            .get()
                            .get();

            if (!snapshot.exists()) {

                System.out.println(
                        "Maintenance not found: "
                                + maintenanceId
                );

                return null;
            }

            return documentToMaintenance(
                    snapshot,
                    secretaryEmail
            );

        } catch (Exception e) {

            System.err.println(
                    "Error getting maintenance by ID:"
            );

            e.printStackTrace();

            return null;
        }
    }

    // =========================================================
    // UPDATE MAINTENANCE STATUS
    // =========================================================
    //
    // Reads:
    //
    // Maintenance/{secretaryEmail}/records/{maintenanceId}
    //
    // =========================================================

    public boolean updateMaintenanceStatus(
            String secretaryEmail,
            String maintenanceId,
            String newStatus) {

        try {

            secretaryEmail =
                    cleanEmail(secretaryEmail);

            maintenanceId =
                    clean(maintenanceId);

            newStatus =
                    normalizeStatus(newStatus);

            if (secretaryEmail.isEmpty()) {

                System.err.println(
                        "Secretary email is missing."
                );

                return false;
            }

            if (maintenanceId.isEmpty()) {

                System.err.println(
                        "Maintenance ID is missing."
                );

                return false;
            }

            if (newStatus.isEmpty()) {

                System.err.println(
                        "New status is missing."
                );

                return false;
            }

            // -------------------------------------------------
            // DOCUMENT REFERENCE
            // -------------------------------------------------

            DocumentReference recordReference =
                    firestore
                            .collection(
                                    MAINTENANCE_COLLECTION
                            )
                            .document(
                                    secretaryEmail
                            )
                            .collection(
                                    RECORDS_COLLECTION
                            )
                            .document(
                                    maintenanceId
                            );

            // -------------------------------------------------
            // CHECK EXISTENCE
            // -------------------------------------------------

            DocumentSnapshot snapshot =
                    recordReference
                            .get()
                            .get();

            if (!snapshot.exists()) {

                System.err.println(
                        "Maintenance record not found: "
                                + maintenanceId
                );

                return false;
            }

            // -------------------------------------------------
            // UPDATE
            // -------------------------------------------------

            recordReference
                    .update(
                            "status",
                            newStatus
                    )
                    .get();

            System.out.println(
                    "Maintenance status updated successfully."
            );

            System.out.println(
                    "Secretary = "
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
                    "Error updating maintenance status:"
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // DELETE MAINTENANCE
    // =========================================================

    public boolean deleteMaintenance(
            String secretaryEmail,
            String maintenanceId) {

        try {

            secretaryEmail =
                    cleanEmail(secretaryEmail);

            maintenanceId =
                    clean(maintenanceId);

            if (
                    secretaryEmail.isEmpty() ||
                    maintenanceId.isEmpty()
            ) {
                return false;
            }

            DocumentReference reference =
                    firestore
                            .collection(
                                    MAINTENANCE_COLLECTION
                            )
                            .document(
                                    secretaryEmail
                            )
                            .collection(
                                    RECORDS_COLLECTION
                            )
                            .document(
                                    maintenanceId
                            );

            DocumentSnapshot snapshot =
                    reference
                            .get()
                            .get();

            if (!snapshot.exists()) {

                System.err.println(
                        "Maintenance record not found."
                );

                return false;
            }

            reference
                    .delete()
                    .get();

            System.out.println(
                    "Maintenance deleted successfully: "
                            + maintenanceId
            );

            return true;

        } catch (Exception e) {

            System.err.println(
                    "Error deleting maintenance:"
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // CONVERT FIRESTORE DOCUMENT TO MODEL
    // =========================================================

    private Maintenance documentToMaintenance(
            DocumentSnapshot document,
            String secretaryEmail) {

        try {

            if (
                    document == null ||
                    !document.exists()
            ) {
                return null;
            }

            // -------------------------------------------------
            // MAINTENANCE ID
            // -------------------------------------------------

            String maintenanceId =
                    getString(
                            document,
                            "maintenanceId"
                    );

            if (maintenanceId.isEmpty()) {

                maintenanceId =
                        document.getId();
            }

            // -------------------------------------------------
            // AMOUNT
            // -------------------------------------------------

            String amount =
                    getString(
                            document,
                            "amount"
                    );

            // -------------------------------------------------
            // MONTH
            // -------------------------------------------------

            String month =
                    getString(
                            document,
                            "month"
                    );

            // -------------------------------------------------
            // DATE
            // -------------------------------------------------

            String date =
                    getString(
                            document,
                            "date"
                    );

            // -------------------------------------------------
            // STATUS
            // -------------------------------------------------

            String status =
                    normalizeStatus(
                            getString(
                                    document,
                                    "status"
                            )
                    );

            // -------------------------------------------------
            // SECRETARY EMAIL
            // -------------------------------------------------

            String addedBySecretaryEmail =
                    getString(
                            document,
                            "addedBySecretaryEmail"
                    );

            if (
                    addedBySecretaryEmail.isEmpty()
            ) {

                addedBySecretaryEmail =
                        cleanEmail(
                                secretaryEmail
                        );
            }

            // -------------------------------------------------
            // SOCIETY
            // -------------------------------------------------

            String society =
                    getString(
                            document,
                            "society"
                    );

            // -------------------------------------------------
            // CREATE MODEL
            // -------------------------------------------------
            //
            // First 3 fields are kept empty because
            // maintenance is now society-wide.
            //
            // No resident name / flat number is stored.
            //
            // -------------------------------------------------

            Maintenance maintenance =
                    new Maintenance(
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

            // -------------------------------------------------
            // IMPORTANT:
            // STORE FIRESTORE DOCUMENT ID IN MODEL
            // -------------------------------------------------

            maintenance.setMaintenanceId(
                    maintenanceId
            );

            return maintenance;

        } catch (Exception e) {

            System.err.println(
                    "Error converting maintenance document:"
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

        Object value =
                document.get(field);

        if (value == null) {

            return "";
        }

        return String
                .valueOf(value)
                .trim();
    }

    // =========================================================
    // CLEAN STRING
    // =========================================================

    private String clean(String value) {

        if (value == null) {

            return "";
        }

        return value.trim();
    }

    // =========================================================
    // CLEAN EMAIL
    // =========================================================

    private String cleanEmail(String email) {

        if (email == null) {

            return "";
        }

        return email
                .trim()
                .toLowerCase();
    }

    // =========================================================
    // NORMALIZE STATUS
    // =========================================================

    private String normalizeStatus(String status) {

        if (status == null) {

            return "";
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

        return value;
    }
}