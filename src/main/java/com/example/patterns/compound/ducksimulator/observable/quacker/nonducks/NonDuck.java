package com.example.patterns.compound.ducksimulator.observable.quacker.nonducks;

import com.example.patterns.compound.ducksimulator.observable.ObservableImpl;
import com.example.patterns.compound.ducksimulator.observable.quacker.Quackable;
import com.example.patterns.compound.ducksimulator.observer.Observer;

public abstract class NonDuck implements Quackable {
    private ObservableImpl observableQuacker;

    public NonDuck() {
        observableQuacker = new ObservableImpl(this);
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