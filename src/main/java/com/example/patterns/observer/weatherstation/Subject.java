package com.example.patterns.observer.weatherstation;

public interface Subject {
    void register(Observer o);
    void remove(Observer o);
    void notifyObservers();
}