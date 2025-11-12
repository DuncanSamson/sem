package com.napier.sem;

import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        Connection con = Connector.connect();

        // Run the report using the established connection
        //All the countries in the world organised by largest population to smallest.
        CountryPopulationReport report = new CountryPopulationReport();
        report.displayCountriesByPopulation(con);
        // Close the connection
        Connector.close(con);
        }

    }
