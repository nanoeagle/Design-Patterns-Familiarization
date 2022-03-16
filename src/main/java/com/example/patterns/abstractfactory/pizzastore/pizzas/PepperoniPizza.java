package com.example.patterns.abstractfactory.pizzastore.pizzas;

import com.example.patterns.abstractfactory.pizzastore.ingredientfactories.*;

public class PepperoniPizza extends Pizza {
    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    public void prepare() {
        prepareBasicsOfPizza();
        veggies = ingredientFactory.createVeggies();
        pepperoni = ingredientFactory.createPepperoni();
    }
}