package com.example.patterns.observer.weatherstation.weatherdisplays;

import com.example.patterns.observer.weatherstation.*;

public abstract class AbstractWeatherDisplay implements DisplayElement, Observer {
    WeatherData weatherData;

    AbstractWeatherDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.register(this);
    }

    @Override
    public void unsubscribeFromSubject() {
        weatherData.remove(this);
    }
}