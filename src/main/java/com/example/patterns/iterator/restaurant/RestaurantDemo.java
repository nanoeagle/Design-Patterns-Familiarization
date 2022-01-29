package com.example.patterns.iterator.restaurant;

import java.util.Set;

import com.example.patterns.iterator.restaurant.menu.*;

public class RestaurantDemo {
    public static void main(String[] args) {
        Waitress waitress = new Waitress(
            Set.of(new PancakeHouseMenu(), new DinerMenu(), new CafeMenu()));
        waitress.printMenu(); 
    }
}