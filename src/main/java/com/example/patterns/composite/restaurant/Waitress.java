package com.example.patterns.composite.restaurant;

import com.example.patterns.composite.restaurant.menu.*;

public class Waitress {
    private MenuComponent allMenus;
    
    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }
    
    public void printMenu() {
        allMenus.print();
    }
}