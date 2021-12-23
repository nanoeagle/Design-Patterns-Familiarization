package com.example.patterns.observer.weatherstation;

import com.example.patterns.observer.weatherstation.weatherdisplays.*;

public class WeatherStation {
    private WeatherData weatherData;

    public WeatherStation() {
        weatherData = new WeatherData();
    }

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        DisplayElement[] displays = weatherStation.createDisplays();
        float[][] measurementSets = {
            {80, 65, 30.4f}, {201, 70, 29.2f}, {-1, 90, 29.2f}};
        
        for (float[] ms : measurementSets) {
            weatherStation.updateMeasurements(ms);
            System.out.println("--- New measurements ---");
            for (DisplayElement d : displays) d.display();
            System.out.println();
        }
    }

    private DisplayElement[] createDisplays() {
        DisplayElement environmentalConditions = 
            new EnvironmentalConditionsDisplay(weatherData);
        DisplayElement statistics = new StatisticsDisplay(weatherData);
        DisplayElement forecast = new ForecastDisplay(weatherData);
        DisplayElement heatIndex = new HeatIndexDisplay(weatherData);
        return new DisplayElement[] {
            environmentalConditions, statistics, forecast, heatIndex};
    }

    private void updateMeasurements(float[] ms) {
        weatherData.setMeasurements(ms[0], ms[1], ms[2]);
        weatherData.notifyObservers();
    }
}