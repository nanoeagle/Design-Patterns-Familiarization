package com.example.patterns.compound.ducksimulator.observable.quacker.factories;

import com.example.patterns.compound.ducksimulator.observable.quacker.*;
import com.example.patterns.compound.ducksimulator.observable.quacker.ducks.*;
import com.example.patterns.compound.ducksimulator.observable.quacker.nonducks.*;

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

    @Override
    public Quackable createGooseDuck() {
        return new QuackCounter(new GooseAdapter(new Goose()));
    }
}