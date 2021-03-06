package com.example.patterns.abstractfactory.pizzastore.pizzas;

import com.example.patterns.abstractfactory.pizzastore.ingredientfactories.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.cheeses.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.clams.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.dough.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.pepperoni.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.sauce.*;
import com.example.patterns.abstractfactory.pizzastore.ingredients.veggies.*;

public abstract class Pizza {
    String name;
    PizzaIngredientFactory ingredientFactory;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    Veggie veggies[];
    Pepperoni pepperoni;
    Clam clams;
    
    Pizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void prepare();

    void prepareBasicsOfPizza() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
    
    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    
    public void box() {
        System.out.println("Place pizza in an official PizzaStore box");
    }

    @Override
    public String toString() {
        String result = "\n---- " + name + " ----\n";
		if (dough != null) result += dough + "\n";
		if (sauce != null) result += sauce + "\n";
		if (cheese != null) result += cheese + "\n";
		if (pepperoni != null) result += pepperoni + "\n";
		if (clams != null) result += clams + "\n";
		if (veggies != null) 
            for (int i = 0; i < veggies.length; i++) 
                result += veggies[i] + ((i == veggies.length - 1) ? "." : ", ");
		return result += "\n";
    }
}