package com.example.patterns.abstractfactory.pizzastore;

import com.example.patterns.abstractfactory.pizzastore.pizzas.*;
import com.example.patterns.abstractfactory.pizzastore.stores.*;

public class PizzaStoreDemo {
    public static void main(String[] args) {
        PizzaStore newYorkStore = new NewYorkPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        try {
            Pizza pizza = newYorkStore.makePizzaBasedOn(PizzaType.CHEESE);
            System.out.println("Ethan ordered a " + pizza);
            pizza = chicagoStore.makePizzaBasedOn(PizzaType.CHEESE);
            System.out.println("Joel ordered a " + pizza);

            pizza = newYorkStore.makePizzaBasedOn(PizzaType.VEGGIE);
            System.out.println("Kavin ordered a " + pizza);
            pizza = chicagoStore.makePizzaBasedOn(PizzaType.VEGGIE);
            System.out.println("Bright ordered a " + pizza);

            pizza = chicagoStore.makePizzaBasedOn(null);
            System.out.println("Emma didn't order any pizza!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}