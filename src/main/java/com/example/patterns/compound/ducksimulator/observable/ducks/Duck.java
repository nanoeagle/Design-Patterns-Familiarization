package com.example.patterns.compound.ducksimulator.observable.ducks;

import com.example.patterns.compound.ducksimulator.observable.*;

public abstract class Duck extends Fowl implements Quackable {
    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObservers();
    }
}