package com.example.patterns.compound.ducksimulator.observable.quacker.factories;

import com.example.patterns.compound.ducksimulator.observable.quacker.Quackable;
import com.example.patterns.compound.ducksimulator.observable.quacker.ducks.*;
import com.example.patterns.compound.ducksimulator.observable.quacker.nonducks.*;

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
