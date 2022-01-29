package com.example.patterns.iterator.restaurant.menu;

import java.util.*;

public class CafeMenu implements DinnerMenu {
    private Map<String, MenuItem> menuItemMap;
    private Collection<MenuItem> menuItems;
    
    public CafeMenu() {
        menuItemMap = new HashMap<String, MenuItem>();
        menuItems = menuItemMap.values();

        addItem("Veggie Burger and Air Fries",
            "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
            true, 3.99);
        addItem("Soup of the day",
            "A cup of the soup of the day, with a side salad",
            false, 3.69);
        addItem("Burrito",
            "A large burrito, with whole pinto beans, salsa, guacamole",
            true, 4.29);
    }

    @Override
    public void addItem(String name, String description, 
        boolean vegetarian, double price) 
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItemMap.put(name, menuItem);
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return menuItems.iterator();
    }
}