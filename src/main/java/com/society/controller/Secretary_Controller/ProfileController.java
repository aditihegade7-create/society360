package com.society.controller.Secretary_Controller;

import com.society.dao.Welcome.UserDao;
import com.society.model.Secretary_model.ProfileModel;

public class ProfileController {

    private UserDao userDao;

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public ProfileController() {

        userDao = new UserDao();
    }

    // ============================================================
    // GET LOGGED-IN PROFILE
    // ============================================================

    public ProfileModel getProfile() {

        String email =
                UserDao.getLoggedInEmail();

        if (email == null ||
                email.trim().isEmpty()) {

            System.out.println(
                    "No logged-in user email found.");

            return null;
        }

        System.out.println(
                "Loading profile for: "
                + email);

        return userDao.getLoggedInProfile();
    }

    // ============================================================
    // UPDATE PROFILE
    // ============================================================

    public boolean saveProfile(
            String name,
            String email,
            String mobile,
            String society) {

        // ========================================================
        // VALIDATION
        // ========================================================

        if (name == null ||
                name.trim().isEmpty()) {

            System.out.println(
                    "Name is required.");

            return false;
        }

        if (email == null ||
                email.trim().isEmpty()) {

            System.out.println(
                    "Email is required.");

            return false;
        }

        if (mobile == null ||
                mobile.trim().isEmpty()) {

            System.out.println(
                    "Mobile is required.");

            return false;
        }

        if (society == null ||
                society.trim().isEmpty()) {

            System.out.println(
                    "Society is required.");

            return false;
        }

        // ========================================================
        // UPDATE FIRESTORE
        // ========================================================

        return userDao.updateLoggedInProfile(
                name.trim(),
                email.trim(),
                mobile.trim(),
                society.trim()
        );
    }
}