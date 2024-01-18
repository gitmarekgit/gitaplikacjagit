package com.example.gitprojektgit;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
public class DatabaseManager {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/git";
    private static final String USERNAME = "root"; // Domyślny użytkownik w XAMPP
    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

