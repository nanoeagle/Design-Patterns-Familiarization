package com.example.patterns.compound.ducksimulator.observable.quacker;

import com.example.patterns.compound.ducksimulator.observable.Observable;

public interface Quackable extends Observable {
    void quack();
}