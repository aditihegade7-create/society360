package com.society.dao.Secretary_dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;

import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.Resident;

public class ResidentDaoImpl implements ResidentDao {

    private final Firestore firestore;

    private static final String COLLECTION = "Residents";

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public ResidentDaoImpl() {
        firestore = FirebaseConfig.getFirestore();
    }

    // =========================================================
    // ADD / SAVE RESIDENT
    // =========================================================

    @Override
    public boolean addResident(Resident resident) {

        try {

            if (resident == null) {
                System.out.println("Resident is null.");
                return false;
            }

            String email = cleanEmail(
                    resident.getEmail()
            );

            if (email.isEmpty()) {
                System.out.println(
                        "Resident email is empty."
                );
                return false;
            }

            /*
             * IMPORTANT
             *
             * Email is ALWAYS Firestore document ID.
             *
             * Residents
             *      |
             *      └── vaishnavi@gmail.com
             *
             */

            String documentPath = email;

            /*
             * Only update fields coming from
             * ManageResidents UI.
             *
             * Existing fields such as:
             *
             * aadhar
             * address
             * dob
             * gender
             * joiningDate
             * memberSince
             * ownerName
             * role
             * society
             *
             * will remain safe because we are using
             * update/merge style logic.
             */

            Map<String, Object> data =
                    new HashMap<>();

            data.put(
                    "name",
                    resident.getName()
            );

            data.put(
                    "flatNo",
                    resident.getFlatNo()
            );

            data.put(
                    "phone",
                    resident.getPhone()
            );

            data.put(
                    "email",
                    email
            );

            data.put(
                    "status",
                    resident.getStatus()
            );

            /*
             * Check whether document already exists.
             */

            DocumentSnapshot existing =
                    firestore
                            .collection(COLLECTION)
                            .document(documentPath)
                            .get()
                            .get();

            if (existing.exists()) {

                /*
                 * Existing complete resident data
                 * is preserved.
                 */

                firestore
                        .collection(COLLECTION)
                        .document(documentPath)
                        .set(
                                data,
                                com.google.cloud.firestore.SetOptions
                                        .merge()
                        )
                        .get();

                System.out.println(
                        "Existing resident updated successfully."
                );

            } else {

                /*
                 * If document does not exist,
                 * create it.
                 *
                 * In this case only UI fields will
                 * be available.
                 */

                firestore
                        .collection(COLLECTION)
                        .document(documentPath)
                        .set(data)
                        .get();

                System.out.println(
                        "New resident created successfully."
                );
            }

            System.out.println(
                    "Resident Document ID = "
                            + email
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error saving resident: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // GET ALL RESIDENTS
    // =========================================================

    @Override
    public List<Resident> getAllResidents() {

        List<Resident> residents =
                new ArrayList<>();

        try {

            ApiFuture<QuerySnapshot> future =
                    firestore
                            .collection(COLLECTION)
                            .get();

            QuerySnapshot snapshot =
                    future.get();

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                try {

                    Resident resident =
                            document.toObject(
                                    Resident.class
                            );

                    if (resident == null) {
                        continue;
                    }

                    /*
                     * Email must always be available.
                     *
                     * First try email field.
                     * If missing, use document ID.
                     */

                    if (resident.getEmail() == null
                            || resident.getEmail()
                                    .trim()
                                    .isEmpty()) {

                        resident.setEmail(
                                document.getId()
                        );
                    }

                    /*
                     * Make sure email is normalized.
                     */

                    resident.setEmail(
                            cleanEmail(
                                    resident.getEmail()
                            )
                    );

                    residents.add(resident);

                } catch (Exception ex) {

                    System.out.println(
                            "Error converting resident document: "
                                    + document.getId()
                    );

                    ex.printStackTrace();
                }
            }

            System.out.println(
                    "Total residents fetched = "
                            + residents.size()
            );

        } catch (Exception e) {

            System.out.println(
                    "Error fetching residents: "
                            + e.getMessage()
            );

            e.printStackTrace();
        }

        return residents;
    }

    // =========================================================
    // GET RESIDENT BY EMAIL
    // =========================================================

    @Override
    public Resident getResidentByEmail(
            String email
    ) {

        try {

            email = cleanEmail(email);

            if (email.isEmpty()) {
                return null;
            }

            DocumentSnapshot document =
                    firestore
                            .collection(COLLECTION)
                            .document(email)
                            .get()
                            .get();

            if (!document.exists()) {

                System.out.println(
                        "Resident not found for email: "
                                + email
                );

                return null;
            }

            Resident resident =
                    document.toObject(
                            Resident.class
                    );

            if (resident != null) {

                /*
                 * Always use document ID as
                 * the trusted email identifier.
                 */

                resident.setEmail(email);
            }

            return resident;

        } catch (Exception e) {

            System.out.println(
                    "Error fetching resident by email: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return null;
        }
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
}