package com.society.controller.welcome;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class AuthController {

    private static final String API_KEY =
            "AIzaSyAcyT5P1xMuNiTrIV1oRieZ4oft_GzUejA";

    private static final String PROJECT_ID =
            "society360-6db56";

    // ================= SIGN UP =================

    public String signUp(String email, String password) {

        JSONObject payload = new JSONObject()
                .put("email", email)
                .put("password", password)
                .put("returnSecureToken", true);

        try {

            HttpClient client = HttpClient.newHttpClient();

            URI uri = URI.create(
                    "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key="
                            + API_KEY
            );

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .POST(
                            HttpRequest.BodyPublishers
                                    .ofString(payload.toString())
                    )
                    .build();

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            System.out.println("SIGN UP STATUS: "
                    + response.statusCode());

            System.out.println("SIGN UP RESPONSE: "
                    + response.body());

            if (response.statusCode() == 200) {

                JSONObject result =
                        new JSONObject(response.body());

                String uid =
                        result.getString("localId");

                return uid;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }


    // ================= FIRESTORE =================

    public boolean saveUserToFirestore(
            String uid,
            String name,
            String phone,
            String dob,
            String email,
            String gender,
            String role,
            String society
    ) {

        JSONObject fields = new JSONObject();

        fields.put(
                "name",
                new JSONObject().put("stringValue", name)
        );

        fields.put(
                "phone",
                new JSONObject().put("stringValue", phone)
        );

        fields.put(
                "dob",
                new JSONObject().put("stringValue", dob)
        );

        fields.put(
                "email",
                new JSONObject().put("stringValue", email)
        );

        fields.put(
                "gender",
                new JSONObject().put("stringValue", gender)
        );

        fields.put(
                "role",
                new JSONObject().put("stringValue", role)
        );

        fields.put(
                "society",
                new JSONObject().put("stringValue", society)
        );


        JSONObject document = new JSONObject();

        document.put("fields", fields);


        try {

            HttpClient client =
                    HttpClient.newHttpClient();

            URI uri = URI.create(
                    "https://firestore.googleapis.com/v1/projects/"
                            + PROJECT_ID
                            + "/databases/(default)/documents/users/"
                            + uid
            );


            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(uri)
                            .header(
                                    "Content-Type",
                                    "application/json"
                            )
                            .method(
                                    "PATCH",
                                    HttpRequest.BodyPublishers
                                            .ofString(
                                                    document.toString()
                                            )
                            )
                            .build();


            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers
                                    .ofString()
                    );


            System.out.println(
                    "FIRESTORE STATUS: "
                            + response.statusCode()
            );

            System.out.println(
                    "FIRESTORE RESPONSE: "
                            + response.body()
            );


            return response.statusCode() == 200;


        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }


    // ================= LOGIN =================

    public boolean signIn(
            String email,
            String password
    ) {

        JSONObject payload = new JSONObject()
                .put("email", email)
                .put("password", password)
                .put("returnSecureToken", true);


        try {

            HttpClient client =
                    HttpClient.newHttpClient();


            URI uri = URI.create(
                    "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key="
                            + API_KEY
            );


            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(uri)
                            .header(
                                    "Content-Type",
                                    "application/json"
                            )
                            .POST(
                                    HttpRequest.BodyPublishers
                                            .ofString(
                                                    payload.toString()
                                            )
                            )
                            .build();


            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers
                                    .ofString()
                    );


            System.out.println(
                    response.statusCode()
            );

            System.out.println(
                    response.body()
            );


            return response.statusCode() == 200;


        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }
}