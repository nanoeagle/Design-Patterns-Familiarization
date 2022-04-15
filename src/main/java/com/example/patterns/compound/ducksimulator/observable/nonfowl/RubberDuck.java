package com.example.patterns.compound.ducksimulator.observable.nonfowl;

public class RubberDuck extends NonFowl {
    @Override
    public void quack() {
        System.out.println("Squeak");
        notifyObservers();
    }
}