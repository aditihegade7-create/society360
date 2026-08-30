package com.society.controller.Secretary_Controller;

import java.util.List;

import com.society.dao.Secretary_dao.OwnerDao;
import com.society.dao.Secretary_dao.OwnerDaoImpl;
import com.society.model.Secretary_model.Owner;

public class OwnerController {

    private OwnerDao ownerDao;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public OwnerController() {

        ownerDao = new OwnerDaoImpl();
    }

    // =====================================================
    // ADD OWNER
    // =====================================================

    public boolean addOwner(
            String name,
            String flat,
            String mobile,
            String email,
            String status) {

        Owner owner =
                new Owner(
                        name,
                        flat,
                        mobile,
                        email,
                        status
                );

        return ownerDao.addOwner(owner);
    }

    // =====================================================
    // FETCH ALL OWNERS
    // =====================================================

    public List<Owner> getAllOwners() {

        return ownerDao.getAllOwners();
    }
}