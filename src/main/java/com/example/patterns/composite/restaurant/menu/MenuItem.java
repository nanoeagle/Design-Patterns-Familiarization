package com.example.patterns.composite.restaurant.menu;

public final class MenuItem extends MenuComponent {
    private boolean vegetarian;
    private double price;
    
    public MenuItem(String name, String description, 
        boolean vegetarian, double price) {
        super(name, description);
        this.vegetarian = vegetarian;
        this.price = price;
    }
    
    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public void print() {
        System.out.print(name);
        if (isVegetarian()) System.out.print(" (v)");
        System.out.println(", " + price + "$");
        if ( !description.isEmpty())
            System.out.println("\t-- " + description);
    }
}