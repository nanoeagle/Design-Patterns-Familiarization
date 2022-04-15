package com.example.patterns.compound.ducksimulator.observable.nonfowl;

import java.util.*;

import com.example.patterns.compound.ducksimulator.observable.ducks.Quackable;
import com.example.patterns.compound.ducksimulator.observer.Observer;

public abstract class NonFowl implements Quackable {
    private List<Observer> observers;

    public NonFowl() {
        observers = new ArrayList<>();
    }
    
    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) observer.update(this);
    }
}