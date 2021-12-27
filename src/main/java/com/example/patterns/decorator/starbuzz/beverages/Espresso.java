package com.example.patterns.decorator.starbuzz.beverages;

public class Espresso extends Beverage {
    public Espresso() {
        setDescription("Espresso");
    }

    @Override
    public float cost() {
        return 1.99f;
    }
}