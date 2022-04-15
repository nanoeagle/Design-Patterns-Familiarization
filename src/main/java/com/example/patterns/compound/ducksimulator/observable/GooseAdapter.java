package com.example.patterns.compound.ducksimulator.observable;

import com.example.patterns.compound.ducksimulator.observable.ducks.Quackable;
import com.example.patterns.compound.ducksimulator.observer.Observer;

/* Adapter pattern. */
public class GooseAdapter implements Quackable {
    private Goose goose;
    
    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }
    
    @Override
    public void quack() {
        goose.honk();
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        goose.register(observer);
    }

    @Override
    public void notifyObservers() {
        goose.notifyObservers();        
    }
}