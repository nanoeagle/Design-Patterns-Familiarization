package com.example.patterns.decorator.starbuzz.condiments;

import com.example.patterns.decorator.starbuzz.beverages.Beverage;

public class Soya extends CondimentDecorator {
    public Soya(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soya";
    }

    @Override
    public float cost() {
        float cost = beverage.cost();
        switch (getSize()) {
            case TALL: cost += 0.1f; break;
            case GRANDE: cost += 0.15f; break;
            case VENTI: cost += 0.2f; break;
        }
        return cost;
    }
}