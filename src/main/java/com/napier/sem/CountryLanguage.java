package com.napier.sem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryLanguage {
    private String CountryCode;
    private String Language;
    private String IsOfficial;
    private String Percentage;

    public CountryLanguage(String countryCode, String percentage, String isOfficial, String language) {
        CountryCode = countryCode;
        Percentage = percentage;
        IsOfficial = isOfficial;
        Language = language;
    }

    public static CountryLanguage fromResultSet(ResultSet rs) throws SQLException {
        return new CountryLanguage(
          rs.getString("CountryCode"),
          rs.getString("Percentage"),
          rs.getString("IsOfficial"),
          rs.getString("Language")
        );
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public String getIsOfficial() {
        return IsOfficial;
    }

    public String getPercentage() {
        return Percentage;
    }
}
