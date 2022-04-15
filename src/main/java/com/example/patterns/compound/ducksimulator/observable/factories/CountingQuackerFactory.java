package com.example.patterns.compound.ducksimulator.observable.factories;

import com.example.patterns.compound.ducksimulator.observable.ducks.*;
import com.example.patterns.compound.ducksimulator.observable.nonfowl.*;

public class CountingQuackerFactory extends AbstractQuackerFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }
    
    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }
    
    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }
    
    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }
}