package com.example.patterns.compound.ducksimulator.observable.nonfowl;

public class DuckCall extends NonFowl {
    @Override
    public void quack() {
        System.out.println("Kwak");
        notifyObservers();
    }
}