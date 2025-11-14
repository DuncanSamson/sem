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

    public List<Country> TheTopNPopulatedCountriesInARegionWhereNIsProvidedByTheUser(String regionName , int topN) {
        String query = "SELECT * FROM country WHERE Region = ? ORDER BY Population DESC LIMIT ?";
        List<Country> countries = new ArrayList<>();
        System.out.print("TheTopNPopulatedCountriesInARegionWhereNIsProvidedByTheUser: " + query);
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, regionName);
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

    public List<City> AllTheCitiesInAContinentOrganisedByLargestPopulationToSmallest(String continentName) {
        String query = "SELECT ci.ID, ci.Name, ci.CountryCode, ci.Population, ci.District FROM country c JOIN city ci ON c.Code = ci.CountryCode WHERE c.Continent LIKE ? ORDER BY c.Population DESC";
        List<City> cities = new ArrayList<>();
        System.out.println("AllTheCitiesInAContinentWhereNIsProvidedByTheUser: " + query);
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, continentName);
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

    public List<City> AllTheCitiesInARegionOrganisedByLargestPopulationToSmallest (String regionName) {
        String query = "SELECT ci.ID, ci.Name, ci.CountryCode, ci.Population, ci.District FROM country c JOIN city ci ON c.Code = ci.CountryCode WHERE c.Region  LIKE ? ORDER BY c.Population DESC";
        List<City> cities = new ArrayList<>();
        System.out.println("AllTheCitiesInAContinentWhereNIsProvidedByTheUser: " + query);
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, regionName);
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

    public List<City> AllTheCitiesInACountryOrganisedByLargestPopulationToSmallest (String countryName) {
        String query = "SELECT ci.ID, ci.Name, ci.CountryCode, ci.Population, ci.District FROM country c JOIN city ci ON c.Code = ci.CountryCode WHERE c.Name  LIKE ? ORDER BY ci.Population DESC";
        List<City> cities = new ArrayList<>();
        System.out.println("AllTheCitiesInACountryOrganisedByLargestPopulationToSmallest: " + query);
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, countryName);
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

    public List<City> AllTheCitiesInADistrictOrganisedByLargestPopulationToSmallest (String districtName) {
        String query = "SELECT ci.ID, ci.Name, ci.CountryCode, ci.Population, ci.District FROM country c JOIN city ci ON c.Code = ci.CountryCode WHERE ci.District  LIKE ? ORDER BY ci.Population DESC";
        List<City> cities = new ArrayList<>();
        System.out.println("AllTheCitiesInACountryOrganisedByLargestPopulationToSmallest: " + query);
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, districtName);
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

    public List<City> TheTopNPopulatedCitiesInTheWorldWhereNIsProvidedByTheUser (int topN) {
        String query = "SELECT * FROM city ORDER BY Population DESC LIMIT ?";
        List<City> cities = new ArrayList<>();
        System.out.println("TheTopNPopulatedCitiesInTheWorldWhereNIsProvidedByTheUser: " + query);
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, topN);
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


