package com.society.service.resident_service;

public class UserSession {

    private static String email;

    public static void setEmail(String email) {
        UserSession.email = email;
    }

    public static String getEmail() {
        return email;
    }

    public static void clear() {
        email = null;
    }
}