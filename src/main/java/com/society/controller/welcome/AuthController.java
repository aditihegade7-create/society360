package com.society.controller.welcome;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class AuthController {

        private static final String API_KEY = "AIzaSyAcyT5P1xMuNiTrIV1oRieZ4oft_GzUejA";


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
                                                        + API_KEY);

                        HttpRequest request = HttpRequest.newBuilder()
                                        .uri(uri)
                                        .header("Content-Type", "application/json")
                                        .POST(
                                                        HttpRequest.BodyPublishers
                                                                        .ofString(payload.toString()))
                                        .build();

                        HttpResponse<String> response = client.send(
                                        request,
                                        HttpResponse.BodyHandlers.ofString());

                        System.out.println("SIGN UP STATUS: "
                                        + response.statusCode());

                        System.out.println("SIGN UP RESPONSE: "
                                        + response.body());

                        if (response.statusCode() == 200) {

                                JSONObject result = new JSONObject(response.body());

                                String uid = result.getString("localId");

                                return uid;
                        }

                } catch (Exception e) {

                        e.printStackTrace();
                }

                return null;
        }

        // ================= FIRESTORE =================

        // ================= LOGIN =================

        public boolean signIn(
                        String email,
                        String password) {

                JSONObject payload = new JSONObject()
                                .put("email", email)
                                .put("password", password)
                                .put("returnSecureToken", true);

                try {

                        HttpClient client = HttpClient.newHttpClient();

                        URI uri = URI.create(
                                        "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key="
                                                        + API_KEY);

                        HttpRequest request = HttpRequest.newBuilder()
                                        .uri(uri)
                                        .header(
                                                        "Content-Type",
                                                        "application/json")
                                        .POST(
                                                        HttpRequest.BodyPublishers
                                                                        .ofString(
                                                                                        payload.toString()))
                                        .build();

                        HttpResponse<String> response = client.send(
                                        request,
                                        HttpResponse.BodyHandlers
                                                        .ofString());

                        System.out.println(
                                        response.statusCode());

                        System.out.println(
                                        response.body());

                        return response.statusCode() == 200;

                } catch (Exception e) {

                        e.printStackTrace();

                }

                return false;
        }
}