package com.upt.cti.aplicatiecomandat.DataTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatesAndCities {

    private final ArrayList<String> states;
    private final Map<String, String> cities;

    public StatesAndCities(){
       states =  new ArrayList<String>(){
            {
                add("București");
                add("Iași");
                add("Prahova");
                add("Cluj");
                add("Constanța");
                add("Timiș");
                add("Bacău");
                add("Bihor");
                add("Galați");
                add("Brașov");
                add("Arad");
                add("Alba");
                add("Brăila");
            }
        };

       cities = new HashMap<String, String>() {
           {
               put("București", "Bucuresti");
               put("Bacău", "Bacău");
               put("Brașov", "Brașov");
               put("Brăila", "Brăila");
               put("Galați", "Galați");
               put("Cluj", "Cluj-Napoca");
               put("Constanța", "Constanța");
               put("Dolj", "Craiova");
               put("Iași", "Iași");
               put("Bihor", "Oradea");
               put("Prahova", "Ploiești");
               put("Timiș", "Timișoara");
               put("Alba", "Alba-Iulia");
               put("Arad", "Arad");
           }
       };
    }

    public ArrayList<String> getStates(){
        return states;
    }

    public Map<String, String> getCities(){
        return cities;
    }

}
