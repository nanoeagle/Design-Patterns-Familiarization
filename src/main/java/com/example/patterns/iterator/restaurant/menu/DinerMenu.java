package com.example.patterns.iterator.restaurant.menu;

import com.example.patterns.iterator.restaurant.iterators.*;

public class DinerMenu implements AbstractMenu {
    private static final int MAX_ITEMS = 6;
    private MenuItem[] items;
    private int itemIndex;
    
    public DinerMenu() {
        items = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT",
            "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT",
            "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day",
            "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hotdog",
            "A hot dog, with sauerkraut, relish, onions, topped with cheese",
            false, 3.05);
    }
    
    @Override
    public void addItem(String name, String description, 
        boolean vegetarian, double price) 
    {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        if (itemIndex >= MAX_ITEMS) 
            System.err.println("Sorry, menu is full! Can't add item to menu");
        else {
            items[itemIndex] = item;
            itemIndex++;
        }
    }

    @Override
    public MenuIterator iterator() {
        return new DinerMenuIterator(items);
    }
}