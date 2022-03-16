package com.example.patterns.abstractfactory.pizzastore.pizzas;

import com.example.patterns.abstractfactory.pizzastore.ingredientfactories.*;

public class ClamPizza extends Pizza {
    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    public void prepare() {
        prepareBasicsOfPizza();
        clams = ingredientFactory.createClams();
    }
}