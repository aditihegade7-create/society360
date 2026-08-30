
package com.society.dao.Secretary_dao;

import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.Event;

public class EventDao {

    // =====================================================
    // FIRESTORE
    // =====================================================

    private Firestore firestore;

    // =====================================================
    // COLLECTION NAME
    // =====================================================

    private static final String COLLECTION_NAME = "Events";

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public EventDao() {

        firestore =
                FirebaseConfig.getFirestore();
    }

    // =====================================================
    // ADD EVENT
    // =====================================================

    public boolean addEvent(Event event) {

        try {

            // =============================================
            // ADD EVENT TO FIRESTORE
            // =============================================

            firestore
                    .collection(COLLECTION_NAME)
                    .add(event)
                    .get();

            System.out.println(
                    "Event added successfully to Firestore."
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error while adding event:"
            );

            e.printStackTrace();

            return false;
        }
    }

    // =====================================================
    // GET ALL EVENTS
    // =====================================================

    public List<Event> getAllEvents() {

        List<Event> eventList =
                new ArrayList<>();

        try {

            // =============================================
            // GET ALL DOCUMENTS
            // =============================================

            ApiFuture<QuerySnapshot> future =
                    firestore
                            .collection(COLLECTION_NAME)
                            .get();

            QuerySnapshot querySnapshot =
                    future.get();

            // =============================================
            // CONVERT DOCUMENTS TO EVENT OBJECTS
            // =============================================

            for (DocumentSnapshot document :
                    querySnapshot.getDocuments()) {

                Event event =
                        document.toObject(
                                Event.class
                        );

                if (event != null) {

                    eventList.add(event);
                }
            }

            System.out.println(
                    "Events fetched successfully: "
                    + eventList.size()
            );

        } catch (Exception e) {

            System.out.println(
                    "Error while fetching events:"
            );

            e.printStackTrace();
        }

        return eventList;
    }
}

