package com.example.patterns.abstractfactory.pizzastore.pizzas;

public enum PizzaType {
    CHEESE("Cheese"), VEGGIE("Veggie"), CLAM("Clam"), PEPPERONI("Pepperoni");
    
    private String value;

    private PizzaType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}