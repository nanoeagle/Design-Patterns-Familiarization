package com.example.patterns.abstractfactory.pizzastore.stores;

import com.example.patterns.abstractfactory.pizzastore.ingredientfactories.*;

public class NewYorkPizzaStore extends PizzaStore {
    public NewYorkPizzaStore() {
        ingredientFactory = new NewYorkPizzaIngredientFactory();
        region = "New York";
    }
}