package com.example.patterns.observer.weatherstation;

import com.example.patterns.observer.weatherstation.data.WeatherData;
import com.example.patterns.observer.weatherstation.weatherdisplays.*;

public class WeatherStation {
    private WeatherData weatherData;

    public WeatherStation() {
        weatherData = new WeatherData();
    }

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        AbstractWeatherDisplay[] displays = weatherStation.createDisplays();
        float[][] measurementSets = {
            {80, 65, 30.4f}, {201, 70, 29.2f}, {-1, 90, 29.2f}};
        
        for (float[] ms : measurementSets) {
            weatherStation.updateMeasurements(ms);
            System.out.println("--- New measurements ---");
            for (DisplayElement d : displays) d.display();
            System.out.println();
        }
        
        System.out.println("--- Unsubscribe the heatIndexDisplay " 
            + "from its weatherData. ---");
        displays[3].unsubscribeFromSubject();
        System.out.println("--- Update new measurements. ---");
        weatherStation.updateMeasurements(new float[] {15, 30, 34.2f});
        displays[3].display();
    }

    private AbstractWeatherDisplay[] createDisplays() {
        AbstractWeatherDisplay environmentalConditions = 
            new EnvironmentalConditionsDisplay(weatherData);
        AbstractWeatherDisplay statistics = new StatisticsDisplay(weatherData);
        AbstractWeatherDisplay forecast = new ForecastDisplay(weatherData);
        AbstractWeatherDisplay heatIndex = new HeatIndexDisplay(weatherData);
        return new AbstractWeatherDisplay[] {
            environmentalConditions, statistics, forecast, heatIndex};
    }

    private void updateMeasurements(float... ms) {
        weatherData.setMeasurements(ms[0], ms[1], ms[2]);
        weatherData.notifyObservers();
    }
}