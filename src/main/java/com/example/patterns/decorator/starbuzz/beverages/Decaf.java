package com.example.patterns.decorator.starbuzz.beverages;

public class Decaf extends Beverage {
    public Decaf() {
        setDescription("House Blend Coffee");
    }

    @Override
    public float cost() {
        return 1.05f;
    }
}