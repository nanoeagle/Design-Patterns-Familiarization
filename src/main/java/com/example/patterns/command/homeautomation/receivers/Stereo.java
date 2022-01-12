package com.example.patterns.command.homeautomation.receivers;

public class Stereo extends HouseholdDevice {
    public Stereo(String location) throws IllegalArgumentException {
        super(location);
    }

    public void on() {
        System.out.println(location + " stereo is on");
    }

    public void off() {
        System.out.println(location + " stereo is off");
    }

    public void setCD() {
        System.out.println(location + " stereo is set for CD input");
    }

    public void setDVD() {
        System.out.println(location + " stereo is set for DVD input");
    }

    public void setRadio() {
        System.out.println(location + " stereo is set for Radio");
    }

    public void setVolume(int volume) {
        System.out.println(location + " stereo volume set to " + volume);
    }
}