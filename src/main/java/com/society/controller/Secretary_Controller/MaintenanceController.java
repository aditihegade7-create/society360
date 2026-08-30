
package com.society.controller.Secretary_Controller;

import java.util.List;

import com.society.dao.Secretary_dao.MaintenanceDao;
import com.society.model.Secretary_model.Maintenance;

public class MaintenanceController {

    private MaintenanceDao maintenanceDao;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public MaintenanceController() {

        maintenanceDao = new MaintenanceDao();
    }

    // =====================================================
    // ADD MAINTENANCE
    // =====================================================

    public boolean addMaintenance(
            String email,
            String residentName,
            String flatNo,
            String amount,
            String month,
            String date,
            String status) {

        Maintenance maintenance = new Maintenance(
                email,
                residentName,
                flatNo,
                amount,
                month,
                date,
                status);

        return maintenanceDao.addMaintenance(
                maintenance);
    }
    // =====================================================
    // GET ALL MAINTENANCE
    // =====================================================

    public List<Maintenance> getAllMaintenance() {

        return maintenanceDao.getAllMaintenance();
    }
}
