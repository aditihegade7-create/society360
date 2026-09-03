package com.society.service.resident_service;

public class SecretarySession {

    private static String loggedInEmail;

    public static void setLoggedInEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            loggedInEmail = null;
            return;
        }

        loggedInEmail = email.trim();

        System.out.println(
                "SecretarySession Email Set = " + loggedInEmail
        );
    }

    public static String getLoggedInEmail() {

        System.out.println(
                "SecretarySession Email Get = " + loggedInEmail
        );

        return loggedInEmail;
    }

    public static void clear() {

        loggedInEmail = null;

        System.out.println("SecretarySession cleared.");
    }
}