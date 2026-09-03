package com.society.controller.welcome;

import com.society.dao.Welcome.UserDao;
import com.society.service.resident_service.UserSession;
import com.society.view.Guard_portal.GuardDashboard;
import com.society.view.Owner_portal.OwnerDashboard;
import com.society.view.Resident_portal.ResidentDashboard;
import com.society.view.Secretary_portal.SecretaryDashboard;

import javafx.stage.Stage;

public class logincontroller {

        private final UserDao userDao = new UserDao();

        public void login(
                        String email,
                        String password,
                        Stage stage) {

                // ============================================
                // 1. FIREBASE AUTHENTICATION
                // ============================================

                boolean success = userDao.authenticateUser(
                                email,
                                password);

                if (!success) {

                        System.out.println(
                                        "Invalid email or password.");

                        return;
                }

                System.out.println(
                                "Authentication successful.");
                              

                // ============================================
                // 2. GET ROLE FROM FIRESTORE
                // ============================================

                String role = userDao.getUserRole(email);

                if (role == null) {

                        System.out.println(
                                        "Role not found in Firestore.");

                        return;
                }

                System.out.println(
                                "User role: " + role);

                // ============================================
                // 3. OPEN DASHBOARD
                // ============================================

                switch (role.trim().toLowerCase()) {

                        case "resident":

                                com.society.view.Resident_portal.ResidentDashboard residentDashboard = new com.society.view.Resident_portal.ResidentDashboard();

                                residentDashboard.getResidentDashboardScene(stage);

                                break;

                        case "owner":

                                com.society.view.Owner_portal.OwnerDashboard ownerDashboard = new com.society.view.Owner_portal.OwnerDashboard();

                                ownerDashboard.createScene(stage);

                                break;

                        case "secretary":

                                SecretaryDashboard securityDashboard = new SecretaryDashboard();

                                break;

                        case "guard":

                                com.society.view.Guard_portal.GuardDashboard guardDashboard = new com.society.view.Guard_portal.GuardDashboard();

                                guardDashboard.createScene(stage);

                                break;

                        default:

                                System.out.println(
                                                "Invalid role: " + role);
                }
        }
}