package com.napier.sem;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Countries {
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private BigDecimal SurfaceArea;
    private int IndepYear;
    private int Population;
    private BigDecimal LifeExpectancy;
    private BigDecimal GNP;
    private BigDecimal GNPOld;
    private String LocalName;
    private String GovernmentForm;
    private String HeadOfState;
    private int Capital;
    private String Code2;

    public Countries(String code, String code2, int capital, String headOfState, String governmentForm, String localName, BigDecimal gNPOld, BigDecimal gNP, BigDecimal lifeExpectancy, int population, int indepYear, BigDecimal surfaceArea, String region, String continent, String name) {
        Code = code;
        Code2 = code2;
        Capital = capital;
        HeadOfState = headOfState;
        GovernmentForm = governmentForm;
        LocalName = localName;
        GNPOld = gNPOld;
        GNP = gNP;
        LifeExpectancy = lifeExpectancy;
        Population = population;
        IndepYear = indepYear;
        SurfaceArea = surfaceArea;
        Region = region;
        Continent = continent;
        Name = name;
    }

    public static Countries fromResultSet(ResultSet rs) throws SQLException {
        return new Countries(
                rs.getString("Code"),
                rs.getString("Code2"),
                rs.getInt("Capital"),
                rs.getString("HeadOfState"),
                rs.getString("GovernmentForm"),
                rs.getString("localName"),
                rs.getBigDecimal("GNPOld"),
                rs.getBigDecimal("GNP"),
                rs.getBigDecimal("LifeExpectancy"),
                rs.getInt("Population"),
                rs.getInt("IndepYear"),
                rs.getBigDecimal("SurfaceArea"),
                rs.getString("Region"),
                rs.getString("Continent"),
                rs.getString("Name")
        );
    }


    public String getCode() {
        return Code;
    }

    public String getCode2() {
        return Code2;
    }

    public int getCapital() {
        return Capital;
    }

    public String getHeadOfState() {
        return HeadOfState;
    }

    public String getGovernmentForm() {
        return GovernmentForm;
    }

    public String getLocalName() {
        return LocalName;
    }

    public BigDecimal getGNPOld() {
        return GNPOld;
    }

    public BigDecimal getGNP() {
        return GNP;
    }

    public BigDecimal getLifeExpectancy() {
        return LifeExpectancy;
    }

    public int getPopulation() {
        return Population;
    }

    public int getIndepYear() {
        return IndepYear;
    }

    public BigDecimal getSurfaceArea() {
        return SurfaceArea;
    }

    public String getRegion() {
        return Region;
    }

    public String getContinent() {
        return Continent;
    }

    public String getName() {
        return Name;
    }
}
