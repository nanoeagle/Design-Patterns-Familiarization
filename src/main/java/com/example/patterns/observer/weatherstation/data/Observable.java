package com.example.patterns.observer.weatherstation.data;

import com.example.patterns.observer.weatherstation.weatherdisplays.Observer;

public interface Observable {
    void register(Observer o);
    void remove(Observer o);
    void notifyObservers();
}