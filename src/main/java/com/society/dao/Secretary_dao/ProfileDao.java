package com.society.dao.Secretary_dao;

import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.Firestore;

import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.ProfileModel;

/**
 * ============================================================
 * PROFILE DAO
 * ============================================================
 *
 * This DAO handles:
 *
 * 1. Save Profile
 * 2. Fetch Profile
 * 3. Update Profile
 *
 * Firestore Collection:
 *     Profiles
 *
 * Document:
 *     secretary
 *
 * ============================================================
 */
public class ProfileDao {

    private final Firestore firestore;

    private static final String COLLECTION = "Profiles";

    private static final String DOCUMENT_ID = "secretary";


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public ProfileDao() {

        firestore = FirebaseConfig.getFirestore();

        System.out.println(
                "ProfileDao: Firestore connected successfully."
        );
    }


    // ============================================================
    // SAVE / UPDATE PROFILE
    // ============================================================

    public boolean saveProfile(ProfileModel profile) {

        try {

            if (profile == null) {

                System.out.println(
                        "ProfileDao: Profile object is null."
                );

                return false;
            }

            /*
             * set()
             *
             * If document does not exist:
             *     creates it
             *
             * If document already exists:
             *     updates it
             *
             * Therefore you will have only one Secretary profile.
             */

            firestore
                    .collection(COLLECTION)
                    .document(DOCUMENT_ID)
                    .set(profile)
                    .get();

            System.out.println(
                    "Profile saved successfully in Firestore."
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Profile save error: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return false;
        }
    }


    // ============================================================
    // FETCH PROFILE
    // ============================================================

    public ProfileModel getProfile() {

        try {

            /*
             * First try to get the fixed document:
             *
             * Profiles
             *      |
             *      └── secretary
             */

            DocumentSnapshot document =
                    firestore
                            .collection(COLLECTION)
                            .document(DOCUMENT_ID)
                            .get()
                            .get();

            if (document.exists()) {

                ProfileModel profile =
                        document.toObject(
                                ProfileModel.class
                        );

                System.out.println(
                        "Profile fetched successfully."
                );

                return profile;
            }


            /*
             * ====================================================
             * FALLBACK
             * ====================================================
             *
             * If "secretary" document does not exist, check
             * whether Profiles collection contains another
             * document.
             *
             * This is useful if your old code used:
             *
             * collection("Profiles").add(profile)
             *
             * which generates an automatic document ID.
             */

            ApiFuture<QuerySnapshot> future =
                    firestore
                            .collection(COLLECTION)
                            .get();

            QuerySnapshot querySnapshot =
                    future.get();

            if (!querySnapshot.isEmpty()) {

                DocumentSnapshot firstDocument =
                        querySnapshot
                                .getDocuments()
                                .get(0);

                ProfileModel profile =
                        firstDocument.toObject(
                                ProfileModel.class
                        );

                System.out.println(
                        "Profile fetched from existing document: "
                                + firstDocument.getId()
                );

                return profile;
            }


            System.out.println(
                    "No profile found in Firestore."
            );

            return null;

        } catch (Exception e) {

            System.out.println(
                    "Profile fetch error: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return null;
        }
    }


    // ============================================================
    // DELETE PROFILE
    // ============================================================

    public boolean deleteProfile() {

        try {

            firestore
                    .collection(COLLECTION)
                    .document(DOCUMENT_ID)
                    .delete()
                    .get();

            System.out.println(
                    "Profile deleted successfully."
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Profile delete error: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return false;
        }
    }


    // ============================================================
    // GET ALL PROFILES
    // ============================================================

    public List<ProfileModel> getAllProfiles() {

        try {

            QuerySnapshot snapshot =
                    firestore
                            .collection(COLLECTION)
                            .get()
                            .get();

            List<ProfileModel> profiles =
                    new java.util.ArrayList<>();

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                ProfileModel profile =
                        document.toObject(
                                ProfileModel.class
                        );

                if (profile != null) {

                    profiles.add(profile);
                }
            }

            System.out.println(
                    "Total profiles fetched: "
                            + profiles.size()
            );

            return profiles;

        } catch (Exception e) {

            System.out.println(
                    "Get all profiles error: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return new java.util.ArrayList<>();
        }
    }
}