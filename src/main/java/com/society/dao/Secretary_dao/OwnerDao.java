package com.society.dao.Secretary_dao;

import java.util.List;

import com.society.model.Secretary_model.Owner;

public interface OwnerDao {

    // =========================================================
    // ADD OWNER
    // =========================================================

    boolean addOwner(Owner owner);

    // =========================================================
    // GET ALL OWNERS
    // =========================================================

    List<Owner> getAllOwners();

    // =========================================================
    // GET OWNER BY EMAIL
    // =========================================================

    Owner getOwnerByEmail(String email);

    // =========================================================
    // UPDATE OWNER
    // =========================================================

    boolean updateOwner(
            String email,
            String name,
            String flat,
            String mobile,
            String status,
            String society);

    // =========================================================
    // DELETE OWNER
    // =========================================================

    boolean deleteOwner(String email);
}