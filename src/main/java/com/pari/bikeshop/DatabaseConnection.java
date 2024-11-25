package com.pari.bikeshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String jdbcURL = "jdbc:postgresql://localhost:5432/bike_shop";
    private static final String username = "postgres";
    private static final String password = "tArakan123!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }

}
