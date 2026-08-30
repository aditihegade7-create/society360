package com.society.service.resident_service;


    
public class UserSession {

    private static String loggedInEmail;

    public static void setLoggedInEmail(String email) {
        loggedInEmail = email;
    }

    public static String getLoggedInEmail() {
        return loggedInEmail;
    }

    public static void clear() {
        loggedInEmail = null;
    }
}


