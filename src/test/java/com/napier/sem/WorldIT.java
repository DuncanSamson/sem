package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration Tests for the database interaction, specifically testing the
 * CountryPopulationReport functionality against a live MySQL instance.
 */
public class WorldIT
{
    private static Connection con = null;
    private static Reports reports;
    /**
     * Attempts to connect to the MySQL database running in the Docker service.
     * This method runs once before all tests in this class.
     */
    @BeforeAll
    static void connectToDB() {
        System.out.println("Attempting to connect to database for integration tests...");
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 20;
        for (int i = 0; i < retries; ++i)
        {
            try
            {
                // Wait for the DB service to be ready on the GitHub Actions runner (127.0.0.1:33060)
                Thread.sleep(1000);
                // Connect to database using the default port and credentials set in the workflow
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:33060/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "example");
                System.out.println("Successfully connected for integration tests on attempt " + (i + 1));
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + (i + 1));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted.");
            }
        }
        reports = new Reports(con);
    }

    /**
     * Closes the database connection after all tests in this class have run.
     */
    @AfterAll
    static void disconnectFromDB() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Database connection closed.");
            } catch (Exception e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    /**
     * Test to ensure the SQL query correctly orders countries by population.
     */
    @Test
    void testCountryPopulationSorting() {
        if (con == null) {
            fail("Database connection failed, skipping test.");
        }

        try (Statement stmt = con.createStatement()) {
            // Execute the report query but limit it to the top result
            String sql = "SELECT Name FROM country ORDER BY Population DESC LIMIT 1";

            try (ResultSet rs = stmt.executeQuery(sql)) {
                assertTrue(rs.next(), "Query should return at least one country.");

                String topCountry = rs.getString("Name");
                // Based on db/world.sql, China has the largest population (1277558000)
                assertEquals("China", topCountry.trim(), "The top country returned should be China.");

                assertFalse(rs.next(), "Query should only return one result with LIMIT 1.");
            }
        } catch (Exception e) {
            fail("Test failed due to SQL exception: " + e.getMessage());
        }
    }

    /**
     * Simple test to verify the database loaded the correct number of countries (239).
     */
    @Test
    void testTotalCountryCount() {
        if (con == null) {
            fail("Database connection failed, skipping test.");
        }

        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT COUNT(*) AS count FROM country";

            try (ResultSet rs = stmt.executeQuery(sql)) {
                assertTrue(rs.next(), "Count query should return a result.");

                int count = rs.getInt("count");
                // Verify against the number of INSERT INTO country lines in db/world.sql
                assertEquals(239, count, "The total count of countries in the database should be 239.");
            }
        } catch (Exception e) {
            fail("Test failed due to SQL exception: " + e.getMessage());
        }
    }

    @Test
    void testAllTheCountriesInARegionOrganisedByLargestPopulationToSmallest() {
        List<Country> countries = reports.allTheCountriesInARegionOrganisedByLargestPopulationToSmallest("North America");
        assertEquals(5, countries.size(), "The total number of countries should be 5.");
        assertEquals(countries.get(0).getRegion(), "North America", "The region name should be North America.");
        var firstCountry = countries.get(0);
        var firstPopulation = firstCountry.getPopulation();
        var secondCountry = countries.get(1);
        var secondPopulation = secondCountry.getPopulation();
        assertTrue(firstPopulation > secondPopulation, "The population should be greater than the first population.");
    }
}