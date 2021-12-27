package com.example.patterns.decorator.starbuzz.condiments;

import com.example.patterns.decorator.starbuzz.beverages.Beverage;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;

    @Override
    public Size getSize() {
        return beverage.getSize();
    }

    public abstract String getDescription();
}