package com.example.patterns.compound.ducksimulator.observable;

import com.example.patterns.compound.ducksimulator.observer.Observer;

/* Observer pattern. */
public interface Observable {
    void register(Observer observer);
    void notifyObservers();
}