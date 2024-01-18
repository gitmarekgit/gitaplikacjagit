package com.example.gitprojektgit;

public class Session {
    private static String loggedInUserName;

    public static String getLoggedInUserName() {
        return loggedInUserName;
    }

    public static void setLoggedInUserName(String userName) {
        loggedInUserName = userName;
    }
}


