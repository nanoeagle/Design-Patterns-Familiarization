package com.example.patterns.compound.dj.models;

import com.example.patterns.compound.dj.views.Observer;

public interface Observable {
    void register(Observer obs);
    void remove(Observer obs);
}