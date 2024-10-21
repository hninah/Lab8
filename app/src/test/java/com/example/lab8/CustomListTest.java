package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity(){
        CustomList list = MockCityList();
        City city = new City("Cambridge", "Ontario");
        list.addCity(city);
        assertEquals("Belongs in list", list.hasCity(city));
        City notCity = new City("Charlottetown", "Prince Edward Island");
        assertEquals("Does not belong in list", list.hasCity(notCity));
    }

    @Test
    void testDeleteCity(){
        CustomList list = MockCityList();
        City city = new City("Cambridge", "Ontario");
        list.addCity(city);
        assertEquals(1, list.getCount());
        list.delete(city);
        assertEquals(0, list.getCount());
        assertThrows(IllegalArgumentException.class, () -> list.delete(city), "City does not exist");
    }

}
