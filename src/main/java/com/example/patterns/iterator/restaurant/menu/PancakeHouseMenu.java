package com.example.patterns.iterator.restaurant.menu;

import java.util.*;

public class PancakeHouseMenu implements BreakfastMenu {
    private List<MenuItem> items;
    
    public PancakeHouseMenu() {
        items = new ArrayList<>();
        
        addItem("K&B's Pancake Breakfast", 
            "Pancakes with scrambled eggs and toast", true, 2.99);
        addItem("Regular Pancake Breakfast", 
            "Pancakes with fried eggs, sausage", false, 2.99);
        addItem("Blueberry Pancakes",
            "Pancakes made with fresh blueberries",true, 3.49);
        addItem("Waffles",
            "Waffles with your choice of blueberries or strawberries", 
            true, 3.59);
    }

    @Override
    public void addItem(String name, String description,
        boolean vegetarian, double price)
    {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        items.add(item);
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return items.iterator();
    }
}