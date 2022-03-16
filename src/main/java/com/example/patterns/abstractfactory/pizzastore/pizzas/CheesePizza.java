package com.example.patterns.abstractfactory.pizzastore.pizzas;

import com.example.patterns.abstractfactory.pizzastore.ingredientfactories.*;

public class CheesePizza extends Pizza {
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }
 
    @Override
    public void prepare() {
        prepareBasicsOfPizza();
    }
}