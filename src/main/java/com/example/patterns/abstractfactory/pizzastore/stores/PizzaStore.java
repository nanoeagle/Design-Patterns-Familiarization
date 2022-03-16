package com.example.patterns.abstractfactory.pizzastore.stores;

import com.example.patterns.abstractfactory.pizzastore.ingredientfactories.*;
import com.example.patterns.abstractfactory.pizzastore.pizzas.*;

public abstract class PizzaStore {
    PizzaIngredientFactory ingredientFactory;
    String region;

    public Pizza makePizzaBasedOn(PizzaType type) 
    throws UnavailablePizzaTypeException {
        Pizza pizza = createPizzaOf(type);
        pizza.setName(region + " Style " + type + " Pizza");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    
    private Pizza createPizzaOf(PizzaType type) 
    throws UnavailablePizzaTypeException {
        if (type != null) switch (type) {
            case CHEESE: return new CheesePizza(ingredientFactory);
            case VEGGIE: return new VeggiePizza(ingredientFactory);
            case CLAM: return new ClamPizza(ingredientFactory);
            case PEPPERONI: return new PepperoniPizza(ingredientFactory);
        }
        throw new UnavailablePizzaTypeException();
    }
}