package com.napier.sem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class City {
    private int ID;
    private String Name;
    private String CountryCode;
    private String District;
    private int Population;

    public City(int ID, String Name, String CountryCode, String District, int Population) {
        this.ID = ID;
        this.Name = Name;
        this.CountryCode = CountryCode;
        this.District = District;
        this.Population = Population;
    }

    public static City fromResultSet(ResultSet resultSet) throws SQLException {
        return new City(
                resultSet.getInt("ID"),
                resultSet.getString("Name"),
                resultSet.getString("CountryCode"),
                resultSet.getString("District"),
                resultSet.getInt("Population")
        );
    }

    public int getID() {
        return ID;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getName() {
        return Name;
    }

    public String getDistrict() {
        return District;
    }

    public int getPopulation() {
        return Population;
    }
}
