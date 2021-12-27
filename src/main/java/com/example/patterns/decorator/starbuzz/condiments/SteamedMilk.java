package com.example.patterns.decorator.starbuzz.condiments;

import com.example.patterns.decorator.starbuzz.beverages.Beverage;

public class SteamedMilk extends CondimentDecorator {
    public SteamedMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", SteamedMilk";
    }

    @Override
    public float cost() {
        return beverage.cost() + .10f;
    }
}