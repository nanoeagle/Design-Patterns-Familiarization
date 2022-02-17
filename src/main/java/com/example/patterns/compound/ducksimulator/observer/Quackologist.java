package com.example.patterns.compound.ducksimulator.observer;

import com.example.patterns.compound.ducksimulator.observable.Observable;

public class Quackologist implements Observer {
    @Override
    public void update(Observable duck) {
        System.out.println("Quackologist: " 
            + duck.getClass().getSimpleName() + " just quacked.");
    }
}