package com.example.patterns.abstractfactory.pizzastore.pizzas;

import com.example.patterns.abstractfactory.pizzastore.ingredientfactories.*;

public class CheesePizza extends Pizza {
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		super(ingredientFactory);
	}
 
    @Override
	public void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
}