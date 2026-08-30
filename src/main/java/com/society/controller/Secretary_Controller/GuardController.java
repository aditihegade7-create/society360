package com.society.controller.Secretary_Controller;

import java.util.List;

import com.society.dao.Secretary_dao.GuardDao;
import com.society.dao.Secretary_dao.GuardDaoImpl;
import com.society.model.Secretary_model.Guard;

public class GuardController {

    private GuardDao guardDao;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public GuardController() {

        guardDao = new GuardDaoImpl();
    }

    // =====================================================
    // ADD GUARD
    // =====================================================

    public boolean addGuard(
            String name,
            String mobile,
            String shift,
            String email,
            String status,
            String assignedGate) {

        Guard guard = new Guard(
                name,
                mobile,
                shift,
                email,
                status,
                assignedGate
        );

        return guardDao.addGuard(guard);
    }

    // =====================================================
    // UPDATE GUARD
    // =====================================================

    public boolean updateGuard(
            String id,
            String shift,
            String status,
            String assignedGate) {

        if (id == null || id.trim().isEmpty()) {

            return false;
        }

        Guard guard = new Guard();

        guard.setId(id);
        guard.setShift(shift);
        guard.setStatus(status);
        guard.setAssignedGate(assignedGate);

        return guardDao.updateGuard(
                id,
                shift,
                status,
                assignedGate
        );
    }

    // =====================================================
    // FETCH ALL GUARDS
    // =====================================================

    public List<Guard> getAllGuards() {

        return guardDao.getAllGuards();
    }
}