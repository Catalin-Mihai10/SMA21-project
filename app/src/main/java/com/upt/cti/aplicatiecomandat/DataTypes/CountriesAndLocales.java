package com.upt.cti.aplicatiecomandat.DataTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class CountriesAndLocales {
    Locale[] locales;
    ArrayList<String> countries;

    public CountriesAndLocales(){
        locales = Locale.getAvailableLocales();
        countries = new ArrayList<>();

        for(Locale locale : locales){
            String country = locale.getDisplayCountry();
            if(country.trim().length() > 0 && !countries.contains(country)) countries.add(country);
        }

        Collections.sort(countries);
    }

    public Locale[] getLocales(){
        return locales;
    }

    public ArrayList<String> getCountries(){
        return countries;
    }
}
