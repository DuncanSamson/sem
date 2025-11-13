package com.napier.sem;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reports {
    private Connection connection;
    public Reports(Connection con) {
        this.connection = con;
    }
    public List<Country> allTheCountriesInARegionOrganisedByLargestPopulationToSmallest(String regionName) {
        String query = "select * from country where Region = ? ORDER BY Population DESC";
        List<Country> countries = new ArrayList<>();
        System.out.print("allTheCountriesInARegionOrganisedByLargestPopulationToSmallest: " + query);

        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, regionName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                   Country c = Country.fromResultSet(resultSet);
                   countries.add(c);
                }
            }
        }
        catch (SQLException e) {
                e.printStackTrace();
        }
        return countries;
    }


    public List<Country> TheTopNPopulatedCountriesInTheWorldWhereNIsProvidedByTheUser(int topN) {
        String query = "SELECT * FROM country ORDER BY Population DESC LIMIT ?";
        List<Country> countries = new ArrayList<>();
        System.out.print("TheTopNPopulatedCountriesInTheWorldWhereNIsProvidedByTheUser: " + query);

        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, topN);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Country c = Country.fromResultSet(resultSet);
                    countries.add(c);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public List<Country> theTopNPopulatedCountriesInAContinentWhereNIsProvidedByTheUser(String continent, int topN) {
        String query = "SELECT * FROM country WHERE Continent LIKE ? ORDER BY Population DESC LIMIT ?";
        List<Country> countries = new ArrayList<>();
        System.out.print("TheTopNPopulatedCountriesInTheWorldWhereNIsProvidedByTheUser: " + query);

        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, continent);
            statement.setInt(2, topN);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Country c = Country.fromResultSet(resultSet);
                    countries.add(c);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public List<City> AllTheCitiesInTheWorldOrganisedByLargestPopulationToSmallest() {
        String query = "SELECT * FROM city ORDER BY Population DESC";
        List<City> cities = new ArrayList<>();
        System.out.print("AllTheCitiesInTheWorldOrganisedByLargestPopulationToSmallest: " + query);
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    City c = City.fromResultSet(resultSet);
                    cities.add(c);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }



}


