package com.example.patterns.observer.weatherstation;

public interface Observer {
    void update();
    void unsubscribeFromSubject();
}