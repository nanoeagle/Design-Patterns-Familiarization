package com.example.patterns.compound.ducksimulator.observable.quacker;

import com.example.patterns.compound.ducksimulator.observer.Observer;

/* Decorator pattern. */
public class QuackCounter implements Quackable {
    private static int numberOfQuacks;
    private Quackable quacker;
    
    public QuackCounter (Quackable quacker) {
        this.quacker = quacker;
    }
    
    public static int getNumberOfQuacks() {
        return numberOfQuacks;
    }
    
    @Override
    public void quack() {
        quacker.quack();
        numberOfQuacks++;
    }

    @Override
    public void registerObserver(Observer observer) {
        quacker.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        quacker.notifyObservers();
    }
}