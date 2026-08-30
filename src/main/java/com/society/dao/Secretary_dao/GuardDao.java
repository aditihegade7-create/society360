package com.society.dao.Secretary_dao;

import java.util.List;

import com.society.model.Secretary_model.Guard;

public interface GuardDao {

    // =====================================================
    // ADD GUARD
    // =====================================================

    boolean addGuard(Guard guard);

    // =====================================================
    // FETCH ALL GUARDS
    // =====================================================

    List<Guard> getAllGuards();

    // =====================================================
    // UPDATE GUARD
    // =====================================================

    boolean updateGuard(
            String id,
            String shift,
            String status,
            String assignedGate
    );
}