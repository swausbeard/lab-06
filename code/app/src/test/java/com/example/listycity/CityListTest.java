package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
// is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
// This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
// Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        City city2 = new City("Tokyo", "Japan");
        assertFalse(cityList.hasCity(city2));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Brasilia", "Brazil");
        cityList.add(city);
        //Check that list size has been incremented
        assertEquals(2, cityList.getCities().size());
        //Check that the city object exists in the list
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        //Check that list size has been decremented
        assertEquals(1, cityList.getCities().size());
        //Check that the city object no longer exists in the list
        assertFalse(cityList.hasCity(city));
        //Check that an exception is thrown when attempting to delete a  city from the list
        //that doesn't exist
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        //Check that countCities returns the correct value of a list with 1 item
        assertEquals(1, cityList.countCities());
        City city = new City("Jakarta", "Indonesia");
        cityList.add(city);
        //Check that countCities returns the correct value after increasing size
        assertEquals(2, cityList.countCities());
        //Check that countCities returns the correct value after decreasing size
        cityList.delete(city);
        assertEquals(1, cityList.countCities());
    }
}