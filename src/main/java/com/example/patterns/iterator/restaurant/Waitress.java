package com.example.patterns.iterator.restaurant;

import java.util.*;

import com.example.patterns.iterator.restaurant.menu.*;

public class Waitress {
    private Set<AbstractMenu> menuSet;
    
    public Waitress(Set<AbstractMenu> menuSet) {
        this.menuSet = menuSet;
    }
    
    public void printMenu() {
        System.out.print("MENU");
        for (AbstractMenu menu : menuSet) {
            printKindOf(menu);
            printItemsIn(menu);
        }
    }

    private void printItemsIn(AbstractMenu menu) {
        for (MenuItem item : menu) {
            System.out.print(item.getName() + ", ");
            System.out.print(item.getPrice() + " -- ");
            System.out.println(item.getDescription());
        }
    }

    private void printKindOf(AbstractMenu menu) {
        if (menu instanceof BreakfastMenu)
            System.out.println("\n--- BREAKFAST ---");
        else if (menu instanceof LunchMenu) 
            System.out.println("\n--- LUNCH ---");
    }
}