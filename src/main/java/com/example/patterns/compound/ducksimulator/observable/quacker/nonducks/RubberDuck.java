package com.example.patterns.compound.ducksimulator.observable.quacker.nonducks;

public class RubberDuck extends NonDuck {
    @Override
    public void quack() {
        System.out.println("Squeak");
        notifyObservers();
    }
}