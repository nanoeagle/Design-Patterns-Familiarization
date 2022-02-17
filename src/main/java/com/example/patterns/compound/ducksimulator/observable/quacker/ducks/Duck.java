package com.example.patterns.compound.ducksimulator.observable.quacker.ducks;

import com.example.patterns.compound.ducksimulator.observable.ObservableImpl;
import com.example.patterns.compound.ducksimulator.observable.quacker.Quackable;
import com.example.patterns.compound.ducksimulator.observer.Observer;

public abstract class Duck implements Quackable {
    private ObservableImpl observableQuacker;

    public Duck() {
        observableQuacker = new ObservableImpl(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observableQuacker.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observableQuacker.notifyObservers();
    }
}