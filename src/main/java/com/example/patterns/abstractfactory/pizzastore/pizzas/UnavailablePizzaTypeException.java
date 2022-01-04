package com.example.patterns.abstractfactory.pizzastore.pizzas;

public class UnavailablePizzaTypeException extends IllegalArgumentException {
    public UnavailablePizzaTypeException() {
        this("The chosen pizza type is currently unavailable.");
    }

    public UnavailablePizzaTypeException(String s) {
        super(s);
    }
}