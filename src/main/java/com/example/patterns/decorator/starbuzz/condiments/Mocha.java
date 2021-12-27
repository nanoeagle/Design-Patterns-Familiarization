package com.example.patterns.decorator.starbuzz.condiments;

import com.example.patterns.decorator.starbuzz.beverages.Beverage;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public float cost() {
        return beverage.cost() + .20f;
    }
}