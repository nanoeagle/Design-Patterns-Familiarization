package com.example.patterns.command.homeautomation.receivers;

public class Light extends HouseholdDevice {
    public Light(String location) throws IllegalArgumentException {
        super(location);
    }

    public void on() {
        System.out.println(location + " light is on");
    }

    public void off() {
        System.out.println(location + " light is off");
    }
}