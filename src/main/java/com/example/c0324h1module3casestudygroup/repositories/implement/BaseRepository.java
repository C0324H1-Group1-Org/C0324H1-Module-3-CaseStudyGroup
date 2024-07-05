package com.example.c0324h1module3casestudygroup.repositories.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/daisy?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "huyhoang2k";
    private static Connection connection = null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private BaseRepository() {}

    public static Connection getConnection() {
        return connection;
    }
}
