package com.example.patterns.composite.restaurant.menu;

import java.util.*;

public final class Menu extends MenuComponent {
    private Map<Integer, MenuComponent> menuComponents;
    
    public Menu(String name, String description) {
        super(name, description);
        menuComponents = new LinkedHashMap<>();
    }

    @Override
    public void add(MenuComponent... components) {
        for (MenuComponent menuComponent : components) 
            menuComponents.put(menuComponent.id, menuComponent);
    }

    @Override
    public void remove(MenuComponent... components) {
        for (MenuComponent menuComponent : components) 
            menuComponents.remove(menuComponent.id);
    }

    @Override
    public MenuComponent getChild(int id) {
        return menuComponents.get(id);
    }

    @Override
    public void print() {
        printMenuInfo();
        printMenuItemsIfAny();
        printSubmenusIfAny();
    }

    private void printMenuInfo() {
        System.out.print("\n" + name);
        System.out.println(
            description.isEmpty() ? "" : ", " + description);
        System.out.println("---------------------");
    }

    private void printMenuItemsIfAny() {
        MenuComponent[] menuItems = menuComponents.values().stream()
            .filter(component -> component instanceof MenuItem)
            .toArray(MenuComponent[]::new);
        for (int i = 0; i < menuItems.length; i++) {
            System.out.print("\t" + (i + 1) + ". ");
            menuItems[i].print();
        }
    }

    private void printSubmenusIfAny() {
        menuComponents.values().stream()
            .filter(component -> component instanceof Menu)
            .forEach(component -> component.print());
    }
}