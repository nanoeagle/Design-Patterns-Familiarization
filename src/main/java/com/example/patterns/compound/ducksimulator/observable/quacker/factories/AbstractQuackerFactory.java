package com.example.patterns.compound.ducksimulator.observable.quacker.factories;

import com.example.patterns.compound.ducksimulator.observable.quacker.Quackable;

/* Abstract factory pattern. */
public abstract class AbstractQuackerFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedheadDuck();
    public abstract Quackable createDuckCall();
    public abstract Quackable createRubberDuck();
    public abstract Quackable createGooseDuck();
}