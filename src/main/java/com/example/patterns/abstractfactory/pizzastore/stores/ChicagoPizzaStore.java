package com.example.patterns.abstractfactory.pizzastore.stores;

import com.example.patterns.abstractfactory.pizzastore.ingredientfactories.*;
import com.example.patterns.abstractfactory.pizzastore.pizzas.*;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizzaOf(PizzaType type) throws UnavailablePizzaTypeException {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = 
            new ChicagoPizzaIngredientFactory();
        String region = "Chicago";
        pizza = createPizzaBasedOn(type, ingredientFactory);
        pizza.setName(region + " Style " + type + " Pizza");
        return pizza;
    }
}