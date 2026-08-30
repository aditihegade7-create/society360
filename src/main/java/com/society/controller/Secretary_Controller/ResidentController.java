package com.society.controller.Secretary_Controller;

import java.util.List;

import com.society.dao.Secretary_dao.ResidentDao;
import com.society.dao.Secretary_dao.ResidentDaoImpl;
import com.society.model.Secretary_model.Resident;

public class ResidentController {

    private ResidentDao residentDao;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public ResidentController() {

        residentDao = new ResidentDaoImpl();
    }

    // =====================================================
    // ADD RESIDENT
    // =====================================================

    public boolean addResident(
            String name,
            String flat,
            String mobile,
            String email,
            String status) {

        Resident resident = new Resident(
                name,
                flat,
                mobile,
                email,
                status
        );

        return residentDao.addResident(resident);
    }

    // =====================================================
    // FETCH ALL RESIDENTS
    // =====================================================

    public List<Resident> getAllResidents() {

        return residentDao.getAllResidents();
    }
}