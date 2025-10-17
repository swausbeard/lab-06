package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable{
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Getter for city name
     * @return
     * return city name string
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Getter for province name
     * @return
     * return province name string
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Lexicographically compare two city names with each other
     * @param o the object to be compared.
     *          where o is a city object
     * @return
     * return an int representing the comparison. return 0 if equal, negative if name 1 is
     * lexicographically lesser than name 2, and a positive int if name 1 is lexicographically
     * greater than name 2
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}

