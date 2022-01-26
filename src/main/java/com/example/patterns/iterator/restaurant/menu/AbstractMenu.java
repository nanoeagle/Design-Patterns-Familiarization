package com.example.patterns.iterator.restaurant.menu;

import com.example.patterns.iterator.restaurant.iterators.MenuIterator;

public interface AbstractMenu {
    void addItem(String name, String description, 
        boolean vegetarian, double price);
    MenuIterator iterator();
}