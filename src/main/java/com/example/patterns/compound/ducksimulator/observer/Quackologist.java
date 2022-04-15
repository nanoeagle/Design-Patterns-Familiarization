package com.example.patterns.compound.ducksimulator.observer;

import com.example.patterns.compound.ducksimulator.observable.Observable;
import com.example.patterns.compound.ducksimulator.observable.ducks.Quackable;

public class Quackologist implements Observer {
    @Override
    public void update(Observable observable) {
        String className = observable.getClass().getSimpleName();
        String message = observable instanceof Quackable ? 
            "just quacked" : "is not quackable";
        System.out.println("Quackologist: " + className + " " + message + ".");
    }
}