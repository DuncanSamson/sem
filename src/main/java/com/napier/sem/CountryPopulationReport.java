package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CountryPopulationReport
{

    /**
     * the program will desplay a report of countries ordered by population from largest to smallest.
     *
     */
    public void displayCountriesByPopulation(Connection con) {
        if (con == null)
        {
            System.out.println("Connection is null. Cannot generate report.");
            return;
        }

        try
        {
            // SQL Statement
            Statement stmt = con.createStatement();


            // Selects the Name and Population from the 'country' table
            // and sorts them in descending order of population (biggest to smallest).
            String query = "SELECT Name, Population FROM country ORDER BY Population DESC";


            ResultSet rs = stmt.executeQuery(query);

            // Print Header
            System.out.println("\n------------------------------------------------------------------");
            System.out.printf("| %-52s | %-15s |\n", "Country Name", "Population");
            System.out.println("------------------------------------------------------------------");

            //Loop through the results and display them
            while (rs.next())
            {
                String countryName = rs.getString("Name");
                // Retrieving data from the 'country' table in db/world.sql
                int population = rs.getInt("Population");

                // Print row, formatting the population number for clarity
                System.out.printf("| %-52s | %15d |\n", countryName, population);
            }

            System.out.println("------------------------------------------------------------------");
            System.out.println("Report Complete.");

            // Close the result set and statement
            rs.close();
            stmt.close();

        }
        catch (Exception e)
        {
            System.out.println("Error generating the country population report.");
            System.out.println(e.getMessage());
        }
    }
}