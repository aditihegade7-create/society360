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

    private Firestore firestore;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public OwnerDaoImpl() {

        firestore = FirebaseConfig.getFirestore();
    }

    // =====================================================
    // ADD OWNER
    // =====================================================

    @Override
    public boolean addOwner(Owner owner) {

        try {

            firestore.collection("Owners")
                    .add(owner)
                    .get();

            System.out.println(
                    "Owner added successfully!"
            );

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    // =====================================================
    // FETCH ALL OWNERS
    // =====================================================

    @Override
    public List<Owner> getAllOwners() {

        List<Owner> owners =
                new ArrayList<>();

        try {

            // Fetch data from same Owners collection

            ApiFuture<QuerySnapshot> future =
                    firestore.collection("Owners")
                            .get();

            QuerySnapshot snapshot =
                    future.get();

            // =================================================
            // LOOP THROUGH FIRESTORE DOCUMENTS
            // =================================================

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                Owner owner =
                        document.toObject(
                                Owner.class
                        );

                if (owner != null) {

                    owners.add(owner);
                }
            }

            System.out.println(
                    "Owners fetched: "
                    + owners.size()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        return owners;
    }
}