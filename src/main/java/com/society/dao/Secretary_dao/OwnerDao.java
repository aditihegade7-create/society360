package com.society.dao.Secretary_dao;

import java.util.List;

import com.society.model.Secretary_model.Owner;

public interface OwnerDao {

    // =====================================================
    // ADD OWNER
    // =====================================================

    boolean addOwner(Owner owner);

    // =====================================================
    // FETCH ALL OWNERS
    // =====================================================

    List<Owner> getAllOwners();
}