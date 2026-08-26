
package com.society.dao.Welcome;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;

import com.society.config.FirebaseAuthConfig;
import com.society.config.FirebaseConfig;
import com.society.model.Welcome.User;

public class UserDao {

    private final Firestore db = FirebaseConfig.getFirestore();

    private final HttpClient httpClient = HttpClient.newHttpClient();

    // =====================================================
    // GET COLLECTION NAME
    // =====================================================

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

    // =====================================================
    // SAVE USER PROFILE
    // =====================================================

    public boolean saveUser(User user) {

        try {

            if (user == null) {
                return false;
            }

            String collection = getCollectionName(user.getRole());

            if (collection == null) {

                System.out.println(
                        "Invalid role: " + user.getRole());

                return false;
            }

            if (user.getEmail() == null ||
                    user.getEmail().trim().isEmpty()) {

                System.out.println(
                        "Email cannot be empty.");

                return false;
            }

            ApiFuture<?> future = db.collection(collection)
                    .document(user.getEmail())
                    .set(user);

            future.get();

            System.out.println(
                    "User profile saved successfully in "
                            + collection);

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error while saving user:");

            e.printStackTrace();

            return false;
        }
    }
    // =====================================================
    // SIGN UP - CREATE FIREBASE AUTH ACCOUNT
    // =====================================================

    public boolean signUp(String email, String password) {

        try {

            if (email == null || email.trim().isEmpty()) {
                System.out.println("Email is empty.");
                return false;
            }

            if (password == null || password.isEmpty()) {
                System.out.println("Password is empty.");
                return false;
            }

            String url = "https://identitytoolkit.googleapis.com/v1/"
                    + "accounts:signUp?key="
                    + FirebaseAuthConfig.WEB_API_KEY;

            JSONObject requestBody = new JSONObject();

            requestBody.put("email", email.trim());
            requestBody.put("password", password);
            requestBody.put("returnSecureToken", true);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header(
                            "Content-Type",
                            "application/json")
                    .POST(
                            HttpRequest.BodyPublishers.ofString(
                                    requestBody.toString()))
                    .build();

            HttpResponse<String> response = httpClient.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println(
                    "Firebase SignUp Response Code: "
                            + response.statusCode());

            System.out.println(
                    "Firebase SignUp Response: "
                            + response.body());

            // =========================================
            // SUCCESS
            // =========================================

            if (response.statusCode() == 200) {

                System.out.println(
                        "Firebase account created successfully.");

                return true;
            }

            // =========================================
            // ERROR
            // =========================================

            JSONObject errorJson = new JSONObject(response.body());

            JSONObject errorObject = errorJson.optJSONObject("error");

            String errorMessage = errorObject != null
                    ? errorObject.optString(
                            "message",
                            "UNKNOWN_ERROR")
                    : "UNKNOWN_ERROR";

            System.out.println(
                    "Firebase Signup Error: "
                            + errorMessage);

            switch (errorMessage) {

                case "EMAIL_EXISTS":

                    System.out.println(
                            "This email is already registered.");

                    break;

                case "INVALID_EMAIL":

                    System.out.println(
                            "Invalid email address.");

                    break;

                case "WEAK_PASSWORD":

                    System.out.println(
                            "Password is too weak.");

                    break;

                case "OPERATION_NOT_ALLOWED":

                    System.out.println(
                            "Email/Password authentication "
                                    + "is not enabled in Firebase.");

                    break;

                case "INVALID_API_KEY":

                    System.out.println(
                            "Firebase Web API key is invalid.");

                    break;

                case "API_KEY_SERVICE_BLOCKED":

                    System.out.println(
                            "The Firebase API key is blocked "
                                    + "or the required API is disabled.");

                    break;

                default:

                    System.out.println(
                            "Firebase Signup Error: "
                                    + errorMessage);
            }

            return false;

        } catch (Exception e) {

            System.out.println(
                    "Signup exception:");

            e.printStackTrace();

            return false;
        }
    }

    // =====================================================
    // FIREBASE AUTHENTICATION
    // EMAIL + PASSWORD
    // =====================================================

    public boolean authenticateUser(
            String email,
            String password) {

        try {

            if (email == null ||
                    email.trim().isEmpty()) {

                System.out.println(
                        "Email cannot be empty.");

                return false;
            }

            if (password == null ||
                    password.isEmpty()) {

                System.out.println(
                        "Password cannot be empty.");

                return false;
            }

            String url = "https://identitytoolkit.googleapis.com/v1/"
                    + "accounts:signInWithPassword?key="
                    + FirebaseAuthConfig.WEB_API_KEY;

            JSONObject requestBody = new JSONObject();

            requestBody.put(
                    "email",
                    email);

            requestBody.put(
                    "password",
                    password);

            requestBody.put(
                    "returnSecureToken",
                    true);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
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
                    HttpResponse.BodyHandlers.ofString());

            System.out.println(
                    "Firebase Auth Response Code: "
                            + response.statusCode());

            // =================================================
            // LOGIN SUCCESS
            // =================================================

            if (response.statusCode() == 200) {

                JSONObject responseJson = new JSONObject(
                        response.body());

                String idToken = responseJson.optString(
                        "idToken");

                String localId = responseJson.optString(
                        "localId");

                System.out.println(
                        "Firebase Authentication Successful");

                System.out.println(
                        "User ID: " + localId);

                // Do NOT print the idToken.
                // It is a credential.

                return true;
            }

            // =================================================
            // LOGIN FAILED
            // =================================================

            JSONObject errorJson = new JSONObject(
                    response.body());

            String errorMessage = errorJson
                    .optJSONObject("error")
                    .optString(
                            "message",
                            "LOGIN_FAILED");

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

    // =====================================================
    // GET USER BY EMAIL AND ROLE
    // =====================================================

    public User getUser(
            String email,
            String role) {

        try {

            String collection = getCollectionName(role);

            if (collection == null) {

                System.out.println(
                        "Invalid role: " + role);

                return null;
            }

            ApiFuture<DocumentSnapshot> future = db.collection(collection)
                    .document(email)
                    .get();

            DocumentSnapshot document = future.get();

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

    // =====================================================
    // GET USER BY EMAIL
    // =====================================================

    public User getUserByEmail(String email) {

        try {

            String[] collections = {
                    "Residents",
                    "Owners",
                    "Secretaries",
                    "Guards"
            };

            for (String collection : collections) {

                ApiFuture<DocumentSnapshot> future = db.collection(collection)
                        .document(email)
                        .get();

                DocumentSnapshot document = future.get();

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

    // =====================================================
    // GET USER ROLE
    // =====================================================

    public String getUserRole(String email) {

        User user = getUserByEmail(email);

        if (user != null) {

            return user.getRole();
        }

        return null;
    }

    // =====================================================
    // UPDATE USER
    // =====================================================

    public boolean updateUser(User user) {

        try {

            String collection = getCollectionName(
                    user.getRole());

            if (collection == null) {

                System.out.println(
                        "Invalid role: "
                                + user.getRole());

                return false;
            }

            ApiFuture<?> future = db.collection(collection)
                    .document(user.getEmail())
                    .update(
                            "name",
                            user.getName(),

                            "role",
                            user.getRole());

            future.get();

            System.out.println(
                    "User updated successfully");

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error while updating user:");

            e.printStackTrace();

            return false;
        }
    }

    // =====================================================
    // DELETE USER PROFILE
    // =====================================================

    public boolean deleteUser(
            String email,
            String role) {

        try {

            String collection = getCollectionName(role);

            if (collection == null) {

                System.out.println(
                        "Invalid role: " + role);

                return false;
            }

            ApiFuture<?> future = db.collection(collection)
                    .document(email)
                    .delete();

            future.get();

            System.out.println(
                    "User deleted successfully");

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error while deleting user:");

            e.printStackTrace();

            return false;
        }
    }

    // =====================================================
    // GET ALL USERS
    // =====================================================

    public List<User> getUsers(String role) {

        List<User> list = new ArrayList<>();

        try {

            String collection = getCollectionName(role);

            if (collection == null) {

                System.out.println(
                        "Invalid role: " + role);

                return list;
            }

            ApiFuture<QuerySnapshot> future = db.collection(collection)
                    .get();

            QuerySnapshot snapshot = future.get();

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
}