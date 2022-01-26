package com.example.patterns.iterator.restaurant;

import java.util.*;

import com.example.patterns.iterator.restaurant.iterators.*;
import com.example.patterns.iterator.restaurant.menu.*;

public class Waitress {
    private Set<AbstractMenu> menuSet;
    
    public Waitress(Set<AbstractMenu> menuSet) {
        this.menuSet = menuSet;
    }
    
    public void printMenu() {
        Set<MenuIterator> menuIterators = extractMenuIteratorsFromMenuSet();
        System.out.println("MENU");
        printMenuUsing(menuIterators);
    }

    private Set<MenuIterator> extractMenuIteratorsFromMenuSet() {
        Set<MenuIterator> menuIterators = new HashSet<>();
        for (AbstractMenu menu : menuSet) menuIterators.add(menu.iterator());
        return menuIterators;
    }

    private void printMenuUsing(Set<MenuIterator> menuIterators) {
        for (MenuIterator itr : menuIterators) {
            printKindOfMenuBasedOn(itr);
            printMenuItemsUsing(itr);
            System.out.println();
        }
    }

    private void printKindOfMenuBasedOn(MenuIterator itr) {
        if (itr instanceof BreakfastMenuIterator)
            System.out.println("--- BREAKFAST ---");
        else System.out.println("--- LUNCH ---");
    }

    private void printMenuItemsUsing(MenuIterator itr) {
        while (itr.hasNext()) {
            MenuItem menuItem = itr.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
}