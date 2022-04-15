package com.example.patterns.compound.ducksimulator.observable.factories;

import com.example.patterns.compound.ducksimulator.observable.*;
import com.example.patterns.compound.ducksimulator.observable.ducks.*;
import com.example.patterns.compound.ducksimulator.observable.nonfowl.*;

public class QuackerFactory extends AbstractQuackerFactory {
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }
    
    @Override
    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }
    
    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }
    
    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }

    @Override
    public Quackable createGooseDuck() {
        return new GooseAdapter(new Goose());
    }
}
