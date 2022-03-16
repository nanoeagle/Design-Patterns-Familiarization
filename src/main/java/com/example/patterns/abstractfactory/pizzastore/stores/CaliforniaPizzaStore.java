package com.example.patterns.abstractfactory.pizzastore.stores;

import com.example.patterns.abstractfactory.pizzastore.ingredientfactories.*;

public class CaliforniaPizzaStore extends PizzaStore {
    public CaliforniaPizzaStore() {
        ingredientFactory = new CaliforniaPizzaIngredientFactory();
        region = "California";
    }
}