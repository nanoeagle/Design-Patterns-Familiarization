package com.example.patterns.command.homeautomation.receivers;

public class CeilingFan extends HouseholdDevice {
    private PowerLevel powerLevel;
 
    public CeilingFan(String location) throws IllegalArgumentException {
        super(location);
        powerLevel = PowerLevel.OFF;
    }

    public PowerLevel getPowerLevel() {
        return powerLevel;
    }
  
    public void off() {
        powerLevel = PowerLevel.OFF;
        System.out.println(location + " ceiling fan is off");
    }

    public void toLowLevel() {
        powerLevel = PowerLevel.LOW;
        System.out.println(location + " ceiling fan is on low level");
    }

    public void toMediumLevel() {
        powerLevel = PowerLevel.MEDIUM;
        System.out.println(location + " ceiling fan is on medium level");
    }

    public void toHighLevel() {
        powerLevel = PowerLevel.HIGH;
        System.out.println(location + " ceiling fan is on high level");
 
    } 
 
    public enum PowerLevel {
        OFF, LOW, MEDIUM, HIGH
    }
}