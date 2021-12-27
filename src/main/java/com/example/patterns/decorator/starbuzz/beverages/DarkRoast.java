package com.example.patterns.decorator.starbuzz.beverages;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        setDescription("Dark Roast");
    }

    @Override
    public float cost() {
        return 0.99f;
    }
}