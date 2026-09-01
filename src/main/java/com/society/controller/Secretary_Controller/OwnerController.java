package com.society.controller.Secretary_Controller;

import java.util.List;

import com.society.dao.Secretary_dao.OwnerDao;
import com.society.dao.Secretary_dao.OwnerDaoImpl;
import com.society.model.Secretary_model.Owner;

public class OwnerController {

    // =========================================================
    // DAO
    // =========================================================

    private final OwnerDao ownerDao;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public OwnerController() {

        ownerDao =
                new OwnerDaoImpl();
    }

    // =========================================================
    // ADD OWNER
    // =========================================================

    public boolean addOwner(
            String name,
            String flat,
            String mobile,
            String email,
            String status,
            String society) {

        try {

            // -------------------------------------------------
            // VALIDATION
            // -------------------------------------------------

            if (name == null ||
                    name.trim().isEmpty()) {

                return false;
            }

            if (flat == null ||
                    flat.trim().isEmpty()) {

                return false;
            }

            if (mobile == null ||
                    mobile.trim().isEmpty()) {

                return false;
            }

            if (email == null ||
                    email.trim().isEmpty()) {

                return false;
            }

            if (status == null ||
                    status.trim().isEmpty()) {

                return false;
            }

            if (society == null ||
                    society.trim().isEmpty()) {

                return false;
            }

            // -------------------------------------------------
            // NORMALIZE EMAIL
            // -------------------------------------------------

            email =
                    email.trim().toLowerCase();

            // -------------------------------------------------
            // CREATE OWNER
            // -------------------------------------------------

            Owner owner =
                    new Owner(
                            name.trim(),
                            flat.trim(),
                            mobile.trim(),
                            email,
                            status.trim(),
                            society.trim()
                    );

            // -------------------------------------------------
            // SAVE
            // -------------------------------------------------

            return ownerDao.addOwner(
                    owner
            );

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // GET ALL OWNERS
    // =========================================================

    public List<Owner> getAllOwners() {

        try {

            return ownerDao.getAllOwners();

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    // =========================================================
    // GET OWNER BY EMAIL
    // =========================================================

    public Owner getOwnerByEmail(
            String email) {

        try {

            if (email == null ||
                    email.trim().isEmpty()) {

                return null;
            }

            return ownerDao.getOwnerByEmail(
                    email.trim().toLowerCase()
            );

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    // =========================================================
    // UPDATE OWNER
    // =========================================================

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

                return false;
            }

            return ownerDao.updateOwner(
                    email.trim().toLowerCase(),
                    name,
                    flat,
                    mobile,
                    status,
                    society
            );

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // DELETE OWNER
    // =========================================================

    public boolean deleteOwner(
            String email) {

        try {

            if (email == null ||
                    email.trim().isEmpty()) {

                return false;
            }

            return ownerDao.deleteOwner(
                    email.trim().toLowerCase()
            );

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}