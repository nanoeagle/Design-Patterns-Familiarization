package com.example.patterns.iterator.restaurant.menu;

public interface AbstractMenu extends Iterable<MenuItem> {
    void addItem(String name, String description, 
        boolean vegetarian, double price);
}