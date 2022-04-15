package com.example.patterns.compound.ducksimulator.observable.factories;

import com.example.patterns.compound.ducksimulator.observable.ducks.Quackable;

/* Abstract factory pattern. */
public abstract class AbstractQuackerFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedheadDuck();
    public abstract Quackable createDuckCall();
    public abstract Quackable createRubberDuck();
    public Quackable createGooseDuck() {
        throw new UnsupportedOperationException();
    };
}