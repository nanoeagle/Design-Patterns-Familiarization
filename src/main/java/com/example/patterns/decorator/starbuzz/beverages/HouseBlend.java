package com.example.patterns.decorator.starbuzz.beverages;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        setDescription("House Blend");
    }

    @Override
    public float cost() {
        return 0.89f;
    }
}