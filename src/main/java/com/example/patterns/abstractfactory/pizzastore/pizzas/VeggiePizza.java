package com.example.patterns.abstractfactory.pizzastore.pizzas;

import com.example.patterns.abstractfactory.pizzastore.ingredientfactories.*;

public class VeggiePizza extends Pizza {
    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    public void prepare() {
        prepareBasicsOfPizza();
        veggies = ingredientFactory.createVeggies();
    }
}