package com.example.patterns.decorator.starbuzz.condiments;

import com.example.patterns.decorator.starbuzz.beverages.Beverage;

public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public float cost() {
        return beverage.cost() + .1f;
    }
}