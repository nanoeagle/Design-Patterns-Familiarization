package com.example.patterns.compound.ducksimulator.observable;

import java.util.*;

import com.example.patterns.compound.ducksimulator.observer.Observer;

public class ObservableImpl implements Observable {
    private Observable observable;
    private List<Observer> observers;

    public ObservableImpl(Observable observable) {
        this.observable = observable;
        observers = new ArrayList<>();
    }
    
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) observer.update(observable);
    }
}