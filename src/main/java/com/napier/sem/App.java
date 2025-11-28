package com.napier.sem;

import java.sql.*;
import java.util.List;

public class App
{
    private Connection con = null;

    /**
     * MAIN method – used for running the application locally or inside Docker.
     */
    public static void main(String[] args)
    {
        App a = new App();

        // Connect to DB
        if (args.length < 1) {
            a.connect("localhost:33060", 30000);   // Local debugging
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));  // Docker mode
        }

        // Example run: list top 10 countries in the world
        Reports reports = new Reports(a.con);
        List<Country> countries = reports.TheTopNPopulatedCountriesInTheWorldWhereNIsProvidedByTheUser(10);

        System.out.println("\nTop 10 Populated Countries:");
        for (Country c : countries) {
            System.out.println(c.getName() + " — " + c.getPopulation());
        }

        a.disconnect();
    }

    /**
     * Connect to MySQL database (world DB)
     */
    public void connect(String location, int delay)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; i++) {
            System.out.println("Connecting to database...");
            try {
                Thread.sleep(delay);

                con = DriverManager.getConnection(
                        "jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root",
                        "example"
                );


                System.out.println("Successfully connected");
                break;

            } catch (SQLException | InterruptedException e) {
                System.out.println("Connection attempt " + (i + 1) + " failed: " + e.getMessage());
            }
        }
    }

    /**
     * Close the DB connection safely
     */
    public void disconnect()
    {
        if (con != null) {
            try {
                con.close();
                System.out.println("Disconnected");
            }
            catch (Exception e) {
                System.out.println("Error disconnecting database");
            }
        }
    }

    // -------------------------------------------------------------------------
    // OPTIONAL HELPER METHODS FOR Integration Tests
    // -------------------------------------------------------------------------

    /**
     * Fetch a single country by country code.
     */
    public Country getCountry(String code)
    {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM country WHERE Code = ?");
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Country.fromResultSet(rs);
            }
        } catch (Exception e) {
            System.out.println("Error fetching country: " + e.getMessage());
        }
        return null;
    }

    /**
     * Fetch a single city by ID.
     */
    public City getCity(int id)
    {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM city WHERE ID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return City.fromResultSet(rs);
            }
        } catch (Exception e) {
            System.out.println("Error fetching city: " + e.getMessage());
        }
        return null;
    }
}
