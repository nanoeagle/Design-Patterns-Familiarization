package com.example.patterns.compound.ducksimulator.observable.ducks;

import java.util.*;

import com.example.patterns.compound.ducksimulator.observer.Observer;

/* Composite pattern. */
public class FlockOfQuackers implements Quackable {
    private List<Quackable> quackers;
    
    public FlockOfQuackers() {
        quackers = new ArrayList<>();
    }
    
    public void add(Quackable quacker) {
        quackers.add(quacker);
    }
    
    @Override
    public void quack() {
        /* Iterator pattern. */
        for (Quackable quacker : quackers) quacker.quack();
    }

    @Override
    public void register(Observer observer) {
        for (Quackable quacker : quackers) quacker.register(observer);
    }

    @Override
    // will be implemented when each quacker quacks.
    public void notifyObservers() {}
}