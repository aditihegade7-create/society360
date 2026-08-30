package com.society.controller.Secretary_Controller;

import com.society.dao.Secretary_dao.DashboardDao;
import com.society.model.Secretary_model.DashboardData;

/**
 * DashboardController
 *
 * Connects SecretaryDashboard View
 * with DashboardDao.
 */
public class DashboardController {

    // ============================================================
    // DAO
    // ============================================================

    private DashboardDao dashboardDao;

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public DashboardController() {

        dashboardDao =
                new DashboardDao();
    }

    // ============================================================
    // GET DASHBOARD DATA
    // ============================================================

    public DashboardData getDashboardData() {

        try {

            System.out.println(
                    "DashboardController: "
                            + "Requesting dashboard data..."
            );

            DashboardData data =
                    dashboardDao.getDashboardData();

            if (data == null) {

                System.out.println(
                        "DashboardController: "
                                + "No dashboard data received."
                );

                return null;
            }

            System.out.println(
                    "DashboardController: "
                            + "Dashboard data received."
            );

            return data;

        } catch (Exception e) {

            System.out.println(
                    "DashboardController Error: "
                            + e.getMessage()
            );

            e.printStackTrace();

            return null;
        }
    }
}