package com.napier.sem;

import java.sql.*;

public class Connector {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }
    }

    public static Connection connect() {
        Connection con = null;
        int retries = 100;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                Thread.sleep(1000);

                // FIXED: Use correct host + port for macOS host machine
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:33060/world?useSSL=false&allowPublicKeyRetrieval=true",
                        "root",
                        "example"
                );

                System.out.println("Successfully connected");
                break;

            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        return con;
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
}
