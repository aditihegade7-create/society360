package com.society.dao.Secretary_dao;

import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.Owner;

public class OwnerDaoImpl implements OwnerDao {

    private final Firestore firestore;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public OwnerDaoImpl() {

        firestore = FirebaseConfig.getFirestore();

        System.out.println(
                "OwnerDaoImpl: Firestore initialized."
        );
    }

    // =========================================================
    // ADD OWNER
    // EMAIL = FIRESTORE DOCUMENT ID
    // =========================================================

    @Override
    public boolean addOwner(Owner owner) {

        try {

            if (owner == null) {

                System.out.println(
                        "Owner object is null."
                );

                return false;
            }

            String email = owner.getEmail();

            if (email == null ||
                    email.trim().isEmpty()) {

                System.out.println(
                        "Owner email is empty."
                );

                return false;
            }

            // -------------------------------------------------
            // Normalize email
            // -------------------------------------------------

            email = email.trim().toLowerCase();

            // -------------------------------------------------
            // Keep normalized email inside model
            // -------------------------------------------------

            owner.setEmail(email);

            // -------------------------------------------------
            // Check if email already exists
            // -------------------------------------------------

            DocumentSnapshot existingDocument =
                    firestore
                            .collection("Owners")
                            .document(email)
                            .get()
                            .get();

            if (existingDocument.exists()) {

                System.out.println(
                        "Owner already exists with email: "
                                + email
                );

                return false;
            }

            // -------------------------------------------------
            // STORE USING EMAIL AS DOCUMENT ID
            // -------------------------------------------------

            firestore
                    .collection("Owners")
                    .document(email)
                    .set(owner)
                    .get();

            System.out.println(
                    "Owner added successfully."
            );

            System.out.println(
                    "Firestore Document ID: "
                            + email
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error while adding owner."
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // GET ALL OWNERS
    // =========================================================

    @Override
    public List<Owner> getAllOwners() {

        List<Owner> owners =
                new ArrayList<>();

        try {

            ApiFuture<QuerySnapshot> future =
                    firestore
                            .collection("Owners")
                            .get();

            QuerySnapshot snapshot =
                    future.get();

            // -------------------------------------------------
            // LOOP THROUGH DOCUMENTS
            // -------------------------------------------------

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                try {

                    Owner owner =
                            document.toObject(
                                    Owner.class
                            );

                    if (owner != null) {

                        // -------------------------------------------------
                        // Firestore document ID is email
                        // -------------------------------------------------

                        String documentEmail =
                                document.getId();

                        owner.setId(
                                documentEmail
                        );

                        // -------------------------------------------------
                        // If email field is missing,
                        // use document ID
                        // -------------------------------------------------

                        if (owner.getEmail() == null ||
                                owner.getEmail()
                                        .trim()
                                        .isEmpty()) {

                            owner.setEmail(
                                    documentEmail
                            );
                        }

                        owners.add(owner);
                    }

                } catch (Exception e) {

                    System.out.println(
                            "Error reading owner document: "
                                    + document.getId()
                    );

                    e.printStackTrace();
                }
            }

            System.out.println(
                    "Owners fetched: "
                            + owners.size()
            );

        } catch (Exception e) {

            System.out.println(
                    "Error while fetching owners."
            );

            e.printStackTrace();
        }

        return owners;
    }

    // =========================================================
    // GET OWNER BY EMAIL
    // =========================================================

    @Override
    public Owner getOwnerByEmail(String email) {

        try {

            if (email == null ||
                    email.trim().isEmpty()) {

                System.out.println(
                        "Email is empty."
                );

                return null;
            }

            email = email.trim().toLowerCase();

            // -------------------------------------------------
            // Direct document lookup using EMAIL
            // -------------------------------------------------

            DocumentSnapshot document =
                    firestore
                            .collection("Owners")
                            .document(email)
                            .get()
                            .get();

            if (!document.exists()) {

                System.out.println(
                        "Owner not found: "
                                + email
                );

                return null;
            }

            Owner owner =
                    document.toObject(
                            Owner.class
                    );

            if (owner != null) {

                owner.setId(
                        document.getId()
                );

                if (owner.getEmail() == null ||
                        owner.getEmail()
                                .trim()
                                .isEmpty()) {

                    owner.setEmail(
                            document.getId()
                    );
                }
            }

            return owner;

        } catch (Exception e) {

            System.out.println(
                    "Error while fetching owner by email."
            );

            e.printStackTrace();

            return null;
        }
    }

    // =========================================================
    // UPDATE OWNER
    // EMAIL = DOCUMENT ID
    // =========================================================

    @Override
    public boolean updateOwner(
            String email,
            String name,
            String flat,
            String mobile,
            String status,
            String society) {

        try {

            if (email == null ||
                    email.trim().isEmpty()) {

                System.out.println(
                        "Owner email is empty."
                );

                return false;
            }

            email = email.trim().toLowerCase();

            // -------------------------------------------------
            // Check document
            // -------------------------------------------------

            DocumentSnapshot document =
                    firestore
                            .collection("Owners")
                            .document(email)
                            .get()
                            .get();

            if (!document.exists()) {

                System.out.println(
                        "Owner does not exist: "
                                + email
                );

                return false;
            }

            // -------------------------------------------------
            // UPDATE
            // -------------------------------------------------

            firestore
                    .collection("Owners")
                    .document(email)
                    .update(
                            "name",
                            name,

                            "flat",
                            flat,

                            "mobile",
                            mobile,

                            "status",
                            status,

                            "society",
                            society
                    )
                    .get();

            System.out.println(
                    "Owner updated successfully."
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error while updating owner."
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // DELETE OWNER
    // EMAIL = DOCUMENT ID
    // =========================================================

    @Override
    public boolean deleteOwner(String email) {

        try {

            if (email == null ||
                    email.trim().isEmpty()) {

                return false;
            }

            email = email.trim().toLowerCase();

            firestore
                    .collection("Owners")
                    .document(email)
                    .delete()
                    .get();

            System.out.println(
                    "Owner deleted successfully: "
                            + email
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error while deleting owner."
            );

            e.printStackTrace();

            return false;
        }
    }
}