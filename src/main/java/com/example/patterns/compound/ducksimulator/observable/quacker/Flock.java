package com.example.patterns.compound.ducksimulator.observable.quacker;

import java.util.*;

import com.example.patterns.compound.ducksimulator.observer.Observer;

/* Composite pattern. */
public class Flock implements Quackable {
    private List<Quackable> quackers;
    
    public Flock() {
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
    public void registerObserver(Observer observer) {
        for (Quackable quacker : quackers) quacker.registerObserver(observer);
    }

    @Override
    // will be implemented when each quacker quacks.
    public void notifyObservers() {}
}