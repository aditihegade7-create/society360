package com.society.controller.Secretary_Controller;

import java.util.List;

import com.society.dao.Secretary_dao.ResidentDao;
import com.society.dao.Secretary_dao.ResidentDaoImpl;
import com.society.model.Secretary_model.Resident;

public class ResidentController {

    private final ResidentDao residentDao;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public ResidentController() {

        residentDao =
                new ResidentDaoImpl();
    }

    // =========================================================
    // ADD / UPDATE RESIDENT
    // =========================================================

    public boolean addResident(
            String name,
            String flat,
            String mobile,
            String email,
            String status
    ) {

        try {

            Resident resident =
                    new Resident();

            resident.setName(
                    clean(name)
            );

            resident.setFlatNo(
                    clean(flat)
            );

            resident.setPhone(
                    clean(mobile)
            );

            resident.setEmail(
                    cleanEmail(email)
            );

            resident.setStatus(
                    clean(status)
            );

            return residentDao.addResident(
                    resident
            );

        } catch (Exception e) {

            System.out.println(
                    "ResidentController Error: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // GET ALL RESIDENTS
    // =========================================================

    public List<Resident> getAllResidents() {

        return residentDao
                .getAllResidents();
    }

    // =========================================================
    // GET RESIDENT BY EMAIL
    // =========================================================

    public Resident getResidentByEmail(
            String email
    ) {

        return residentDao
                .getResidentByEmail(
                        cleanEmail(email)
                );
    }

    // =========================================================
    // CLEAN VALUE
    // =========================================================

    private String clean(String value) {

        if (value == null) {
            return "";
        }

        return value.trim();
    }

    // =========================================================
    // CLEAN EMAIL
    // =========================================================

    private String cleanEmail(String email) {

        if (email == null) {
            return "";
        }

        return email
                .trim()
                .toLowerCase();
    }
}