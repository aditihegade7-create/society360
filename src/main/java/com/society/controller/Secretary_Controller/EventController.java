
package com.society.controller.Secretary_Controller;

import java.util.List;

import com.society.dao.Secretary_dao.EventDao;
import com.society.model.Secretary_model.Event;

public class EventController {

    // =====================================================
    // DAO
    // =====================================================

    private EventDao eventDao;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public EventController() {

        eventDao = new EventDao();
    }

    // =====================================================
    // ADD EVENT
    // =====================================================

    public boolean addEvent(
            String eventName,
            String date,
            String time,
            String venue,
            String status) {

        // =============================================
        // CREATE EVENT OBJECT
        // =============================================

        Event event =
                new Event(
                        eventName,
                        date,
                        time,
                        venue,
                        status
                );

        // =============================================
        // SEND TO DAO
        // =============================================

        return eventDao.addEvent(event);
    }

    // =====================================================
    // GET ALL EVENTS
    // =====================================================

    public List<Event> getAllEvents() {

        return eventDao.getAllEvents();
    }
}
