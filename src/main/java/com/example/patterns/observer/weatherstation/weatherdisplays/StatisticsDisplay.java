package com.example.patterns.observer.weatherstation.weatherdisplays;

import com.example.patterns.observer.weatherstation.data.WeatherData;

public class StatisticsDisplay extends AbstractWeatherDisplay {
    private float maxTemp = 200;
	private float minTemp = 0.0f;
	private float totalTemperatureOfRecords = 0.0f;
	private int numberOfTemperatureRecords;

	public StatisticsDisplay(WeatherData weatherData) {
		super(weatherData);
	}

    @Override
	public void update() {
        float latestTemp = weatherData.getTemperature();
        totalTemperatureOfRecords += latestTemp;
		numberOfTemperatureRecords++;
        updateTemperatureBoundaryIfIsExceededBy(latestTemp);
	}

	private void updateTemperatureBoundaryIfIsExceededBy(float temp) {
        if (temp > maxTemp) {
			maxTemp = temp;
		} else if (temp < minTemp) {
			minTemp = temp;
		}
    }

    @Override
    public void display() {
		System.out.println("Avg/Max/Min temperatures: " + 
            (totalTemperatureOfRecords / numberOfTemperatureRecords) +
			" / " + maxTemp + " / " + minTemp);
	}
}