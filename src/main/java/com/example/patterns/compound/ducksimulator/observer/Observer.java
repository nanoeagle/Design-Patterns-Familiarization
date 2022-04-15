package com.example.patterns.compound.ducksimulator.observer;

import com.example.patterns.compound.ducksimulator.observable.Observable;

/* Observer pattern. */
@FunctionalInterface
public interface Observer {
    void update(Observable Observable);
}