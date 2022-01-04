package com.example.patterns.abstractfactory.pizzastore.ingredientfactories;

import com.example.patterns.abstractfactory.pizzastore.ingredients.cheeses.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.clams.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.dough.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.pepperoni.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.sauce.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.veggies.*;

public class CaliforniaPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new BBQSauce();
    }

    @Override
    public Cheese createCheese() {
        return new GoatCheese();
    }

    @Override
    public Veggie[] createVeggies() {
        return new Veggie[] {new RedPepper(), new Onion()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clam createClams() {
        return new FreshClam();
    }
}