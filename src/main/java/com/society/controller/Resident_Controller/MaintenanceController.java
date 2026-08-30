package com.society.controller.Resident_Controller;

import com.society.dao.Resident_dao.MaintenanceDAO;
import com.society.model.Resident_model.Maintenance;

import java.util.List;

public class MaintenanceController {

    private final MaintenanceDAO maintenanceDAO;

    public MaintenanceController() {

        maintenanceDAO = new MaintenanceDAO();
    }

    // =========================================================
    // GET FLAT NUMBER
    // =========================================================

    public String getFlatNoByEmail(String email) {

        return maintenanceDAO.getFlatNoByEmail(email);
    }

    // =========================================================
    // GET ALL MAINTENANCE
    // =========================================================

    public List<Maintenance> getMaintenanceByFlatNo(String flatNo) {

        return maintenanceDAO.getMaintenanceByFlatNo(flatNo);
    }

    // =========================================================
    // MARK BILL PAID
    // =========================================================

    public boolean markAsPaid(String documentId) {

        return maintenanceDAO.markAsPaid(documentId);
    }
}