package com.example.patterns.compound.ducksimulator.observable.quacker.nonducks;

public class DuckCall extends NonDuck {
    @Override
    public void quack() {
        System.out.println("Kwak");
        notifyObservers();
    }
}