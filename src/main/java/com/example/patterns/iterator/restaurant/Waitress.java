package com.example.patterns.iterator.restaurant;

import java.util.*;

import com.example.patterns.iterator.restaurant.menu.*;

public class Waitress {
    private Set<AbstractMenu> menuSet;
    
    public Waitress(Set<AbstractMenu> menuSet) {
        this.menuSet = menuSet;
    }
    
    public void printMenu() {
        System.out.print("\nMENU");
        for (AbstractMenu menu : menuSet) {
            printKindOf(menu);
            printItemsIn(menu);
        }
        System.out.println();
    }

    private void printKindOf(AbstractMenu menu) {
        String kind = null;
        if (menu instanceof BreakfastMenu) kind = "\n--- BREAKFAST: ";
        else if (menu instanceof LunchMenu) kind = "\n--- LUNCH: ";
        else kind = "\n--- DINNER: ";
        System.out.println(kind + menu.getClass().getSimpleName() + " ---");
    }

    private void printItemsIn(AbstractMenu menu) {
        for (MenuItem item : menu) {
            System.out.print(item.getName() + ", ");
            System.out.print(item.getPrice() + " -- ");
            System.out.println(item.getDescription());
        }
    }
}