package com.example.patterns.compound.ducksimulator.observable;

import java.util.*;

import com.example.patterns.compound.ducksimulator.observer.Observer;

public class Fowl implements Observable {
    private List<Observer> observers;

    public Fowl() {
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