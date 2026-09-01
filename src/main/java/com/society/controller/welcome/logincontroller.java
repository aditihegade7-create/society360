package com.society.controller.welcome;

import com.society.dao.Welcome.UserDao;
import com.society.model.Welcome.User;
import com.society.view.Guard_portal.GuardDashboard;
import com.society.view.Owner_portal.OwnerDashboard;
import com.society.view.Resident_portal.ResidentDashboard;
import com.society.view.Secretary_portal.SecretaryDashboard;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class logincontroller {

    private final UserDao userDao;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public logincontroller() {

        userDao =
                new UserDao();
    }

    // =========================================================
    // LOGIN
    // =========================================================

    public boolean login(
            String email,
            String password,
            Stage stage) {

        try {

            // =================================================
            // VALIDATION
            // =================================================

            if (email == null ||
                    email.trim().isEmpty()) {

                showAlert(
                        "Login",
                        "Email cannot be empty.");

                return false;
            }

            if (password == null ||
                    password.isEmpty()) {

                showAlert(
                        "Login",
                        "Password cannot be empty.");

                return false;
            }

        String loginEmail =
        email.trim().toLowerCase();
            // =================================================
            // FIREBASE AUTH
            // =================================================

            boolean success =
                    userDao.authenticateUser(
                            loginEmail,
                            password);

            if (!success) {

                showAlert(
                        "Login Failed",
                        "Invalid Email or Password.");

                return false;
            }

            // =================================================
            // GET USER FROM FIRESTORE
            // =================================================

            User user =
                    userDao.getUserByEmail(
                            loginEmail);

            if (user == null) {

                UserDao.clearLoggedInUser();

                showAlert(
                        "Login Error",
                        "Firebase account exists, "
                                + "but your profile was not found "
                                + "in Firestore.");

                return false;
            }

            // =================================================
            // GET ROLE
            // =================================================

            String role =
                    user.getRole();

            if (role == null ||
                    role.trim().isEmpty()) {

                UserDao.clearLoggedInUser();

                showAlert(
                        "Login Error",
                        "User role was not found.");

                return false;
            }

            role =
                    role.trim();

            // =================================================
            // SAVE SESSION
            // =================================================

            UserDao.setLoggedInEmail(
                    loginEmail);

            UserDao.setLoggedInRole(
                    role);

            System.out.println(
                    "Logged-in Email: "
                            + loginEmail);

            System.out.println(
                    "Logged-in Role: "
                            + role);

            System.out.println(
                    "Logged-in User: "
                            + user.getName());

            // =================================================
            // DASHBOARD
            // =================================================

            switch (
                    role.toLowerCase()) {

                // =================================================
                // RESIDENT
                // =================================================

                case "resident": {

                    ResidentDashboard dashboard =
                            new ResidentDashboard();

                    Scene scene =
                            dashboard
                                    .getResidentDashboardScene(
                                            stage);

                    stage.setScene(scene);
                    stage.show();

                    return true;
                }

                // =================================================
                // OWNER
                // =================================================

                case "owner": {

                    OwnerDashboard dashboard =
                            new OwnerDashboard();

                    Scene scene =
                            dashboard.createScene(
                                    stage);

                    stage.setScene(scene);
                    stage.show();

                    return true;
                }

                // =================================================
                // SECRETARY
                // =================================================

                case "secretary": {

                    SecretaryDashboard dashboard =
                            new SecretaryDashboard(
                                    user);

                    Scene scene =
                            dashboard.createScene(
                                    stage);

                    stage.setScene(scene);
                    stage.show();

                    return true;
                }

                // =================================================
                // GUARD
                // =================================================

                case "guard":
                case "security": {

                    GuardDashboard dashboard =
                            new GuardDashboard();

                    Scene scene =
                            dashboard.createScene(
                                    stage);

                    stage.setScene(scene);
                    stage.show();

                    return true;
                }

                // =================================================
                // INVALID ROLE
                // =================================================

                default:

                    UserDao.clearLoggedInUser();

                    showAlert(
                            "Login Error",
                            "Unknown user role: "
                                    + role);

                    return false;
            }

        } catch (Exception e) {

            e.printStackTrace();

            UserDao.clearLoggedInUser();

            showAlert(
                    "Login Error",
                    "Something went wrong while logging in.");

            return false;
        }
    }

    // =========================================================
    // ALERT
    // =========================================================

    private void showAlert(
            String title,
            String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.ERROR);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}