package com.example.patterns.observer.weatherstation.weatherdisplays;

public interface Observer {
    void update();
    void unsubscribeFromSubject();
}