package com.example.patterns.command.homeautomation.receivers;

public abstract class HouseholdDevice {
    String location;

    HouseholdDevice(String location) throws IllegalArgumentException {
        if (location == null) 
            throw new IllegalArgumentException("Must specify the location.");
        this.location = location;
    }
}