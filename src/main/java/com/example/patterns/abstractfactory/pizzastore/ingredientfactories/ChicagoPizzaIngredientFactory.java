package com.example.patterns.abstractfactory.pizzastore.ingredientfactories;

import com.example.patterns.abstractfactory.pizzastore.ingredients.cheeses.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.clams.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.dough.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.pepperoni.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.sauce.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.veggies.*;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }
    
    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }
    
    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }
    
    @Override
    public Veggie[] createVeggies() {
        Veggie veggies[] = {new BlackOlives(), new Spinach(), new Eggplant()};
        return veggies;
    }
    
    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }
    
    @Override
    public Clam createClams() {
        return new FrozenClam();
    }
}