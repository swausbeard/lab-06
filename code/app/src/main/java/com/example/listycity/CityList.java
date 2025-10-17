package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Given a city object, returns true or false based on whether the city is in the list
     * @param city
     * Candidate city to check if it exists in the list
     * @return
     * True if city exists in the list, false otherwise
     */
    public boolean hasCity(City city) {
        if (cities.contains(city)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Removes a city from the list if the city already exists
     * @param city
     * Candidate city to remove
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns the number of cities that exists in the list
     * @return
     * Return integer number of cities
     */
    public int countCities() {
        return cities.size();
    }
}
