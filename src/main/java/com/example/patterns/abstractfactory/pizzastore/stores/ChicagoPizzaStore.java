package com.example.patterns.abstractfactory.pizzastore.stores;

import com.example.patterns.abstractfactory.pizzastore.ingredientfactories.*;

public class ChicagoPizzaStore extends PizzaStore {
    public ChicagoPizzaStore() {
        ingredientFactory = new ChicagoPizzaIngredientFactory();
        region = "Chicago";
    }
}