package com.example.patterns.command.homeautomation.receivers;

public class CeilingFan extends HouseholdDevice {
    private PowerLevel powerLevel;
 
    public CeilingFan(String location) throws IllegalArgumentException {
        super(location);
    }
  
    public void toHighLevel() {
        powerLevel = PowerLevel.HIGH;
        System.out.println(location + " ceiling fan is on high level");
 
    } 

    public void toMediumLevel() {
        powerLevel = PowerLevel.MEDIUM;
        System.out.println(location + " ceiling fan is on medium level");
    }

    public void toLowLevel() {
        powerLevel = PowerLevel.LOW;
        System.out.println(location + " ceiling fan is on low level");
    }
 
    public void off() {
        powerLevel = PowerLevel.OFF;
        System.out.println(location + " ceiling fan is off");
    }
 
    public PowerLevel getPowerLevel() {
        return powerLevel;
    }

    public enum PowerLevel {
        OFF, LOW, MEDIUM, HIGH
    }
}