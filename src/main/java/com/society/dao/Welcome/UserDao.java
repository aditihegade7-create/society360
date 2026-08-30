package com.society.dao.Welcome;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;

import com.society.config.FirebaseAuthConfig;
import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.ProfileModel;
import com.society.model.Welcome.User;

public class UserDao {

        // ============================================================
        // FIRESTORE
        // ============================================================

        private final Firestore db = FirebaseConfig.getFirestore();

        // ============================================================
        // HTTP CLIENT
        // ============================================================

        private final HttpClient httpClient = HttpClient.newHttpClient();

        // ============================================================
        // LOGGED-IN USER SESSION
        // ============================================================

        private static String loggedInEmail;

        private static String loggedInRole;

        // ============================================================
        // SET LOGGED-IN EMAIL
        // ============================================================

        public static void setLoggedInEmail(String email) {

                if (email == null
                                || email.trim().isEmpty()) {

                        loggedInEmail = null;

                } else {

                        loggedInEmail = email.trim();
                }
        }

        // ============================================================
        // GET LOGGED-IN EMAIL
        // ============================================================

        public static String getLoggedInEmail() {

                return loggedInEmail;
        }

        // ============================================================
        // SET LOGGED-IN ROLE
        // ============================================================

        public static void setLoggedInRole(String role) {

                if (role == null
                                || role.trim().isEmpty()) {

                        loggedInRole = null;

                } else {

                        loggedInRole = role.trim();
                }
        }

        // ============================================================
        // GET LOGGED-IN ROLE
        // ============================================================

        public static String getLoggedInRole() {

                return loggedInRole;
        }

        // ============================================================
        // CLEAR LOGIN SESSION
        // ============================================================

        public static void clearLoggedInUser() {

                loggedInEmail = null;
                loggedInRole = null;

                System.out.println(
                                "Logged-in user session cleared.");
        }

        // ============================================================
        // GET COLLECTION NAME
        // ============================================================

        private String getCollectionName(String role) {

                if (role == null) {
                        return null;
                }

                switch (role.trim().toLowerCase()) {

                        case "resident":
                                return "Residents";

                        case "owner":
                                return "Owners";

                        case "secretary":
                                return "Secretaries";

                        case "security":
                        case "guard":
                                return "Guards";

                        default:
                                return null;
                }
        }

        // ============================================================
        // SAVE USER
        // ============================================================

        public boolean saveUser(User user) {

                try {

                        if (user == null) {

                                System.out.println(
                                                "User cannot be null.");

                                return false;
                        }

                        if (user.getEmail() == null
                                        || user.getEmail()
                                                        .trim()
                                                        .isEmpty()) {

                                System.out.println(
                                                "Email cannot be empty.");

                                return false;
                        }

                        String collection = getCollectionName(
                                        user.getRole());

                        if (collection == null) {

                                System.out.println(
                                                "Invalid role: "
                                                                + user.getRole());

                                return false;
                        }

                        String email = user.getEmail()
                                        .trim();

                        db.collection(collection)
                                        .document(email)
                                        .set(user)
                                        .get();

                        System.out.println(
                                        "User profile saved successfully.");

                        System.out.println(
                                        "Collection: "
                                                        + collection);

                        System.out.println(
                                        "Document: "
                                                        + email);

                        return true;

                } catch (Exception e) {

                        System.out.println(
                                        "Error while saving user:");

                        e.printStackTrace();

                        return false;
                }
        }

        // ============================================================
        // FIREBASE SIGN UP
        // ============================================================

        public boolean signUp(
                        String email,
                        String password) {

                try {

                        if (email == null
                                        || email.trim().isEmpty()) {

                                System.out.println(
                                                "Email is empty.");

                                return false;
                        }

                        if (password == null
                                        || password.isEmpty()) {

                                System.out.println(
                                                "Password is empty.");

                                return false;
                        }

                        String url = "https://identitytoolkit.googleapis.com/v1/"
                                        + "accounts:signUp?key="
                                        + FirebaseAuthConfig.WEB_API_KEY;

                        JSONObject requestBody = new JSONObject();

                        requestBody.put(
                                        "email",
                                        email.trim());

                        requestBody.put(
                                        "password",
                                        password);

                        requestBody.put(
                                        "returnSecureToken",
                                        true);

                        HttpRequest request = HttpRequest.newBuilder()
                                        .uri(
                                                        URI.create(url))
                                        .header(
                                                        "Content-Type",
                                                        "application/json")
                                        .POST(
                                                        HttpRequest.BodyPublishers
                                                                        .ofString(
                                                                                        requestBody.toString()))
                                        .build();

                        HttpResponse<String> response = httpClient.send(
                                        request,
                                        HttpResponse.BodyHandlers
                                                        .ofString());

                        System.out.println(
                                        "Firebase SignUp Response Code: "
                                                        + response.statusCode());

                        if (response.statusCode() == 200) {

                                System.out.println(
                                                "Firebase account created successfully.");

                                return true;
                        }

                        JSONObject errorJson = new JSONObject(
                                        response.body());

                        JSONObject errorObject = errorJson.optJSONObject(
                                        "error");

                        String errorMessage = errorObject != null
                                        ? errorObject.optString(
                                                        "message",
                                                        "UNKNOWN_ERROR")
                                        : "UNKNOWN_ERROR";

                        System.out.println(
                                        "Firebase Signup Error: "
                                                        + errorMessage);

                        return false;

                } catch (Exception e) {

                        System.out.println(
                                        "Signup exception:");

                        e.printStackTrace();

                        return false;
                }
        }

        // ============================================================
        // FIREBASE LOGIN
        // ============================================================

        public boolean authenticateUser(
                        String email,
                        String password) {

                try {

                        if (email == null
                                        || email.trim().isEmpty()) {

                                System.out.println(
                                                "Email cannot be empty.");

                                return false;
                        }

                        if (password == null
                                        || password.isEmpty()) {

                                System.out.println(
                                                "Password cannot be empty.");

                                return false;
                        }

                        String loginEmail = email.trim();

                        String url = "https://identitytoolkit.googleapis.com/v1/"
                                        + "accounts:signInWithPassword?key="
                                        + FirebaseAuthConfig.WEB_API_KEY;

                        JSONObject requestBody = new JSONObject();

                        requestBody.put(
                                        "email",
                                        loginEmail);

                        requestBody.put(
                                        "password",
                                        password);

                        requestBody.put(
                                        "returnSecureToken",
                                        true);

                        HttpRequest request = HttpRequest.newBuilder()
                                        .uri(
                                                        URI.create(url))
                                        .header(
                                                        "Content-Type",
                                                        "application/json")
                                        .POST(
                                                        HttpRequest.BodyPublishers
                                                                        .ofString(
                                                                                        requestBody.toString()))
                                        .build();

                        HttpResponse<String> response = httpClient.send(
                                        request,
                                        HttpResponse.BodyHandlers
                                                        .ofString());

                        System.out.println(
                                        "Firebase Auth Response Code: "
                                                        + response.statusCode());

                        // ====================================================
                        // LOGIN SUCCESS
                        // ====================================================

                        if (response.statusCode() == 200) {

                                JSONObject responseJson = new JSONObject(
                                                response.body());

                                String localId = responseJson.optString(
                                                "localId");

                                // ================================================
                                // SAVE EMAIL
                                // ================================================

                                setLoggedInEmail(
                                                loginEmail);

                                // ================================================
                                // GET USER FROM FIRESTORE
                                // ================================================

                                User user = getUserByEmail(
                                                loginEmail);

                                if (user != null) {

                                        setLoggedInRole(
                                                        user.getRole());
                                }

                                System.out.println(
                                                "Firebase Authentication Successful.");

                                System.out.println(
                                                "Logged-in Email: "
                                                                + loggedInEmail);

                                System.out.println(
                                                "User ID: "
                                                                + localId);

                                System.out.println(
                                                "Logged-in Role: "
                                                                + loggedInRole);

                                return true;
                        }

                        // ====================================================
                        // LOGIN FAILED
                        // ====================================================

                        JSONObject errorJson = new JSONObject(
                                        response.body());

                        JSONObject errorObject = errorJson.optJSONObject(
                                        "error");

                        String errorMessage = errorObject != null
                                        ? errorObject.optString(
                                                        "message",
                                                        "LOGIN_FAILED")
                                        : "LOGIN_FAILED";

                        switch (errorMessage) {

                                case "INVALID_LOGIN_CREDENTIALS":
                                case "INVALID_PASSWORD":
                                case "EMAIL_NOT_FOUND":

                                        System.out.println(
                                                        "Invalid email or password.");

                                        break;

                                case "USER_DISABLED":

                                        System.out.println(
                                                        "This account has been disabled.");

                                        break;

                                case "OPERATION_NOT_ALLOWED":

                                        System.out.println(
                                                        "Email/password authentication "
                                                                        + "is disabled in Firebase.");

                                        break;

                                default:

                                        System.out.println(
                                                        "Firebase login error: "
                                                                        + errorMessage);
                        }

                        return false;

                } catch (Exception e) {

                        System.out.println(
                                        "Authentication error:");

                        e.printStackTrace();

                        return false;
                }
        }

        // ============================================================
        // GET USER BY EMAIL AND ROLE
        // ============================================================

        public User getUser(
                        String email,
                        String role) {

                try {

                        if (email == null
                                        || email.trim().isEmpty()) {

                                return null;
                        }

                        String collection = getCollectionName(role);

                        if (collection == null) {

                                System.out.println(
                                                "Invalid role: "
                                                                + role);

                                return null;
                        }

                        DocumentSnapshot document = db.collection(collection)
                                        .document(
                                                        email.trim())
                                        .get()
                                        .get();

                        if (document.exists()) {

                                return document.toObject(
                                                User.class);
                        }

                        System.out.println(
                                        "User not found in "
                                                        + collection);

                } catch (Exception e) {

                        System.out.println(
                                        "Error while getting user:");

                        e.printStackTrace();
                }

                return null;
        }

        // ============================================================
        // GET USER BY EMAIL
        // ============================================================

        public User getUserByEmail(
                        String email) {

                try {

                        if (email == null
                                        || email.trim().isEmpty()) {

                                return null;
                        }

                        String[] collections = {
                                        "Residents",
                                        "Owners",
                                        "Secretaries",
                                        "Guards"
                        };

                        String loginEmail = email.trim();

                        for (String collection : collections) {

                                DocumentSnapshot document = db.collection(collection)
                                                .document(loginEmail)
                                                .get()
                                                .get();

                                if (document.exists()) {

                                        User user = document.toObject(
                                                        User.class);

                                        System.out.println(
                                                        "User found in "
                                                                        + collection);

                                        return user;
                                }
                        }

                        System.out.println(
                                        "No user found with email: "
                                                        + email);

                } catch (Exception e) {

                        System.out.println(
                                        "Error while searching user:");

                        e.printStackTrace();
                }

                return null;
        }

        // ============================================================
        // GET USER ROLE
        // ============================================================

        public String getUserRole(
                        String email) {

                User user = getUserByEmail(email);

                if (user != null) {

                        return user.getRole();
                }

                return null;
        }

        // ============================================================
        // GET LOGGED-IN PROFILE
        // ============================================================

        public ProfileModel getLoggedInProfile() {

                try {

                        if (loggedInEmail == null
                                        || loggedInEmail.trim().isEmpty()) {

                                System.out.println(
                                                "No logged-in user.");

                                return null;
                        }

                        String email = loggedInEmail.trim();

                        String[] collections = {
                                        "Residents",
                                        "Owners",
                                        "Secretaries",
                                        "Guards"
                        };

                        for (String collection : collections) {

                                DocumentSnapshot document = db.collection(collection)
                                                .document(email)
                                                .get()
                                                .get();

                                if (document.exists()) {

                                        String name = getFirestoreString(
                                                        document,
                                                        "name");

                                        String mobile = getFirestoreString(
                                                        document,
                                                        "mobile");

                                        if (mobile.isEmpty()) {

                                                mobile = getFirestoreString(
                                                                document,
                                                                "phone");
                                        }

                                        String society = getFirestoreString(
                                                        document,
                                                        "society");

                                        String role = getFirestoreString(
                                                        document,
                                                        "role");

                                        String status = getFirestoreString(
                                                        document,
                                                        "status");

                                        String memberSince = getFirestoreString(
                                                        document,
                                                        "memberSince");

                                        if (role.isEmpty()) {

                                                role = getRoleFromCollection(
                                                                collection);
                                        }

                                        if (status.isEmpty()) {

                                                status = "Active";
                                        }

                                        String accountType;

                                        if (role.isEmpty()) {

                                                accountType = "Account";

                                        } else {

                                                accountType = role + " Account";
                                        }

                                        if (memberSince.isEmpty()) {

                                                memberSince = "January 2026";
                                        }

                                        ProfileModel profile = new ProfileModel();

                                        profile.setName(name);
                                        profile.setEmail(email);
                                        profile.setMobile(mobile);
                                        profile.setSociety(society);
                                        profile.setRole(role);
                                        profile.setStatus(status);
                                        profile.setAccountType(
                                                        accountType);
                                        profile.setMemberSince(
                                                        memberSince);

                                        System.out.println(
                                                        "Logged-in profile fetched from "
                                                                        + collection);

                                        return profile;
                                }
                        }

                        System.out.println(
                                        "Logged-in profile not found.");

                } catch (Exception e) {

                        System.out.println(
                                        "Error while getting logged-in profile:");

                        e.printStackTrace();
                }

                return null;
        }

        // ============================================================
        // SECRETARY PROFILE
        // ============================================================

        public ProfileModel getSecretaryProfile(
                        String email) {

                try {

                        if (email == null
                                        || email.trim().isEmpty()) {

                                return null;
                        }

                        DocumentSnapshot document = db.collection("Secretaries")
                                        .document(email.trim())
                                        .get()
                                        .get();

                        if (!document.exists()) {

                                System.out.println(
                                                "Secretary profile not found.");

                                return null;
                        }

                        String name = getFirestoreString(
                                        document,
                                        "name");

                        String mobile = getFirestoreString(
                                        document,
                                        "mobile");

                        if (mobile.isEmpty()) {

                                mobile = getFirestoreString(
                                                document,
                                                "phone");
                        }

                        String society = getFirestoreString(
                                        document,
                                        "society");

                        String role = getFirestoreString(
                                        document,
                                        "role");

                        String status = getFirestoreString(
                                        document,
                                        "status");

                        String memberSince = getFirestoreString(
                                        document,
                                        "memberSince");

                        if (role.isEmpty()) {

                                role = "Secretary";
                        }

                        if (status.isEmpty()) {

                                status = "Active";
                        }

                        if (memberSince.isEmpty()) {

                                memberSince = "January 2026";
                        }

                        ProfileModel profile = new ProfileModel();

                        profile.setName(name);
                        profile.setEmail(email.trim());
                        profile.setMobile(mobile);
                        profile.setSociety(society);
                        profile.setRole(role);
                        profile.setStatus(status);
                        profile.setAccountType(
                                        "Secretary Account");
                        profile.setMemberSince(
                                        memberSince);

                        System.out.println(
                                        "Secretary profile loaded successfully.");

                        return profile;

                } catch (Exception e) {

                        System.out.println(
                                        "Error while getting secretary profile:");

                        e.printStackTrace();

                        return null;
                }
        }

        // ============================================================
        // UPDATE LOGGED-IN PROFILE
        // ============================================================

        public boolean updateLoggedInProfile(
                        String name,
                        String email,
                        String mobile,
                        String society) {

                try {

                        if (loggedInEmail == null
                                        || loggedInEmail.trim().isEmpty()) {

                                System.out.println(
                                                "No logged-in account.");

                                return false;
                        }

                        String originalEmail = loggedInEmail.trim();

                        User user = getUserByEmail(
                                        originalEmail);

                        if (user == null) {

                                System.out.println(
                                                "Logged-in user not found.");

                                return false;
                        }

                        String collection = getCollectionName(
                                        user.getRole());

                        if (collection == null) {

                                System.out.println(
                                                "Invalid user role.");

                                return false;
                        }

                        Map<String, Object> updates = new HashMap<>();

                        updates.put(
                                        "name",
                                        name);

                        updates.put(
                                        "email",
                                        originalEmail);

                        updates.put(
                                        "mobile",
                                        mobile);

                        updates.put(
                                        "society",
                                        society);

                        updates.put(
                                        "role",
                                        user.getRole());

                        updates.put(
                                        "status",
                                        "Active");

                        db.collection(collection)
                                        .document(originalEmail)
                                        .update(updates)
                                        .get();

                        System.out.println(
                                        "Logged-in profile updated successfully.");

                        return true;

                } catch (Exception e) {

                        System.out.println(
                                        "Error while updating profile:");

                        e.printStackTrace();

                        return false;
                }
        }

        // ============================================================
        // UPDATE SECRETARY PROFILE
        // ============================================================

        public boolean updateSecretaryProfile(
                        String email,
                        String name,
                        String mobile,
                        String society) {

                try {

                        if (email == null
                                        || email.trim().isEmpty()) {

                                System.out.println(
                                                "Email cannot be empty.");

                                return false;
                        }

                        String secretaryEmail = email.trim();

                        DocumentSnapshot document = db.collection("Secretaries")
                                        .document(secretaryEmail)
                                        .get()
                                        .get();

                        if (!document.exists()) {

                                System.out.println(
                                                "Secretary profile not found.");

                                return false;
                        }

                        Map<String, Object> updates = new HashMap<>();

                        updates.put(
                                        "name",
                                        name);

                        updates.put(
                                        "email",
                                        secretaryEmail);

                        updates.put(
                                        "mobile",
                                        mobile);

                        updates.put(
                                        "society",
                                        society);

                        updates.put(
                                        "role",
                                        "Secretary");

                        updates.put(
                                        "status",
                                        "Active");

                        db.collection("Secretaries")
                                        .document(secretaryEmail)
                                        .update(updates)
                                        .get();

                        System.out.println(
                                        "Secretary profile updated successfully.");

                        return true;

                } catch (Exception e) {

                        System.out.println(
                                        "Error while updating secretary profile:");

                        e.printStackTrace();

                        return false;
                }
        }

        // ============================================================
        // UPDATE USER
        // ============================================================

        public boolean updateUser(User user) {

                try {

                        if (user == null
                                        || user.getEmail() == null
                                        || user.getEmail().trim().isEmpty()) {

                                return false;
                        }

                        String collection = getCollectionName(
                                        user.getRole());

                        if (collection == null) {

                                return false;
                        }

                        db.collection(collection)
                                        .document(
                                                        user.getEmail().trim())
                                        .update(
                                                        "name",
                                                        user.getName(),
                                                        "role",
                                                        user.getRole())
                                        .get();

                        System.out.println(
                                        "User updated successfully.");

                        return true;

                } catch (Exception e) {

                        System.out.println(
                                        "Error while updating user:");

                        e.printStackTrace();

                        return false;
                }
        }

        // ============================================================
        // DELETE USER
        // ============================================================

        public boolean deleteUser(
                        String email,
                        String role) {

                try {

                        String collection = getCollectionName(role);

                        if (collection == null) {

                                return false;
                        }

                        db.collection(collection)
                                        .document(
                                                        email.trim())
                                        .delete()
                                        .get();

                        System.out.println(
                                        "User deleted successfully.");

                        return true;

                } catch (Exception e) {

                        System.out.println(
                                        "Error while deleting user:");

                        e.printStackTrace();

                        return false;
                }
        }

        // ============================================================
        // GET ALL USERS
        // ============================================================

        public List<User> getUsers(
                        String role) {

                List<User> list = new ArrayList<>();

                try {

                        String collection = getCollectionName(role);

                        if (collection == null) {

                                return list;
                        }

                        QuerySnapshot snapshot = db.collection(collection)
                                        .get()
                                        .get();

                        for (DocumentSnapshot doc : snapshot.getDocuments()) {

                                User user = doc.toObject(
                                                User.class);

                                if (user != null) {

                                        list.add(user);
                                }
                        }

                } catch (Exception e) {

                        System.out.println(
                                        "Error while getting users:");

                        e.printStackTrace();
                }

                return list;
        }

        // ============================================================
        // GET RESIDENT BY EMAIL
        // ============================================================

        // ============================================================
        // GET RESIDENT BY FLAT NUMBER
        // ============================================================

        public User getResidentByFlatNo(String flatNo) {

                try {

                        if (flatNo == null || flatNo.trim().isEmpty()) {

                                System.out.println("Flat number cannot be empty.");
                                return null;
                        }

                        QuerySnapshot snapshot = db.collection("Residents")
                                        .whereEqualTo("flatNo", flatNo.trim())
                                        .get()
                                        .get();

                        for (DocumentSnapshot document : snapshot.getDocuments()) {

                                User resident = document.toObject(User.class);

                                if (resident != null) {

                                        System.out.println(
                                                        "Resident found: "
                                                                        + resident.getName());

                                        System.out.println(
                                                        "Resident email: "
                                                                        + resident.getEmail());

                                        return resident;
                                }
                        }

                        System.out.println(
                                        "No resident found for Flat No: "
                                                        + flatNo);

                } catch (Exception e) {

                        System.out.println(
                                        "Error while finding resident by flat number:");

                        e.printStackTrace();
                }

                return null;
        }
        // ============================================================
        // FIRESTORE STRING
        // ============================================================

        private String getFirestoreString(
                        DocumentSnapshot document,
                        String field) {

                Object value = document.get(field);

                if (value == null) {

                        return "";
                }

                return String.valueOf(value);
        }

        // ============================================================
        // ROLE FROM COLLECTION
        // ============================================================

        private String getRoleFromCollection(
                        String collection) {

                switch (collection) {

                        case "Residents":
                                return "Resident";

                        case "Owners":
                                return "Owner";

                        case "Secretaries":
                                return "Secretary";

                        case "Guards":
                                return "Guard";

                        default:
                                return "";
                }
        }
}