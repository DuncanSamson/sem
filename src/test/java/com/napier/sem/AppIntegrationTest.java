package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    static Connection con;
    static Reports reports;

    @BeforeAll
    static void init() {
        // Connect to same local Docker DB used by the App
        con = Connector.connect();     // uses localhost:33060/world
        reports = new Reports(con);
    }

    @Test
    void testTop10Countries() {
        List<Country> countries = reports.TheTopNPopulatedCountriesInTheWorldWhereNIsProvidedByTheUser(10);

        assertNotNull(countries);
        assertEquals(10, countries.size());
        assertTrue(countries.get(0).getPopulation() > countries.get(9).getPopulation());
    }

    @Test
    void testGetCitiesInRegion() {
        List<City> cities = reports.AllTheCitiesInARegionOrganisedByLargestPopulationToSmallest("Eastern Asia");

        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        assertTrue(cities.get(0).getPopulation() >= cities.get(1).getPopulation());
    }
}
