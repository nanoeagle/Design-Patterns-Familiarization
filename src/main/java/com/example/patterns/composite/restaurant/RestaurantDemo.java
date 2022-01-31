package com.example.patterns.composite.restaurant;

import java.util.*;

import com.example.patterns.composite.restaurant.menu.*;

public class RestaurantDemo {
    private Map<String, MenuComponent> menuMap;

    public static void main(String[] args) {
        RestaurantDemo demo = new RestaurantDemo();
        demo.createMenuMap();
        demo.addItemsToEachMenuInMenuMap();
        MenuComponent compositeMenu = demo.createCompositeMenu();
        Waitress waitress = new Waitress(compositeMenu);
        waitress.printMenu();
    }

    private void createMenuMap() {
        menuMap = new LinkedHashMap<>();
        menuMap.put("PANCAKE HOUSE", 
            new Menu("PANCAKE HOUSE MENU", "Breakfast"));
        menuMap.put("DINER", new Menu("DINER MENU", "Lunch"));
        menuMap.put("DESSERT", new Menu("DESSERT MENU", "Dessert"));
        menuMap.put("CAFE", new Menu("CAFE MENU", "Dinner"));
    }

    private void addItemsToEachMenuInMenuMap() {
        addItemsToPancakeHouseMenu();
        addItemsToDinerMenu();
        addItemsToDessertMenu();
        addItemsToCafeMenu();
    }

    private void addItemsToPancakeHouseMenu() {
        menuMap.get("PANCAKE HOUSE").add(
            new MenuItem("K&B's Pancake Breakfast", 
                "Pancakes with scrambled eggs and toast", true, 2.99),
            new MenuItem("Regular Pancake Breakfast", 
                "Pancakes with fried eggs, sausage", false, 2.99),
            new MenuItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries", true, 3.49),
            new MenuItem("Waffles",
                "Waffles with your choice of blueberries or strawberries", 
                true, 3.59));
    }

    private void addItemsToDinerMenu() {
        menuMap.get("DINER").add(
            new MenuItem("Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99),
            new MenuItem("BLT",
                "Bacon with lettuce & tomato on whole wheat", false, 2.99),
            new MenuItem("Soup of the day",
                "Soup of the day, with a side of potato salad", false, 3.29),
            new MenuItem("Hotdog",
                "A hot dog, with sauerkraut, relish, onions, topped with cheese",
                false, 3.05));
    }

    private void addItemsToDessertMenu() {
        menuMap.get("DESSERT").add(
            new MenuItem("Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla icecream",
                true, 1.59),
            new MenuItem("Cheesecake",
                "Creamy New York cheesecake, with a chocolate graham crust",
                true, 1.99),
            new MenuItem("Sorbet",
                "A scoop of raspberry and a scoop of lime", true, 1.89));
    }

    private void addItemsToCafeMenu() {
        menuMap.get("CAFE").add(
            new MenuItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99),
            new MenuItem("Soup of the day",
                "A cup of the soup of the day, with a side salad", false, 3.69),
            new MenuItem("Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29));
    }

    private MenuComponent createCompositeMenu() {
        MenuComponent compositeMenu = new Menu("ALL MENUS", "All menus combined");
        menuMap.get("DINER").add(menuMap.get("DESSERT"));
        menuMap.values().stream()
            .filter(menu -> !menu.getName().equals("DESSERT MENU"))
            .forEach(menu -> compositeMenu.add(menu));
        return compositeMenu;
    }
}