package com.example.patterns.abstractfactory.pizzastore.ingredientfactories;

import com.example.patterns.abstractfactory.pizzastore.ingredients.cheeses.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.clams.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.dough.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.pepperoni.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.sauce.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.veggies.*;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggie[] createVeggies();
    Pepperoni createPepperoni();
    Clam createClams();
}