package com.example.patterns.compound.ducksimulator.observer;

import com.example.patterns.compound.ducksimulator.observable.Observable;

/* Observer pattern. */
public interface Observer {
    void update(Observable duck);
}