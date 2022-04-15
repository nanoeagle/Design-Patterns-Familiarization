package com.example.patterns.compound.dj.models;

import java.util.*;

import com.example.patterns.compound.dj.views.Observer;

public abstract class AbstractObservable implements Observable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void register(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void remove(Observer obs) {
        observers.remove(obs);
    }

    protected void notifyObservers() {
        for (Observer obs : observers) obs.update(this);
    }
}