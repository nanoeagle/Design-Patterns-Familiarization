package com.example.patterns.compound.ducksimulator.observable.ducks;

import com.example.patterns.compound.ducksimulator.observable.Observable;

public interface Quackable extends Observable {
    void quack();
}