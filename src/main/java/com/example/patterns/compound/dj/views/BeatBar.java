package com.example.patterns.compound.dj.views;

import javax.swing.*;

import com.example.patterns.compound.dj.models.Observable;

class BeatBar extends JProgressBar implements Observer {
    private static final int MAX_VALUE = 100;

    private static final long serialVersionUID = 2L;

    private boolean isOn;

    BeatBar() {
        setMinimum(0);
        setMaximum(MAX_VALUE);
    }

    void on() {
        isOn = true;
        Thread pulseThread = new Thread(() -> { 
            while (isOn) visualizePulse(); });
        pulseThread.start();
    }

    void off() {
        isOn = false;
        Thread resetThread = new Thread(() -> {
            while (getValue() != 0) visualizePulse(); });
        resetThread.start();
    }

    private void visualizePulse() {
        int newValue = (int) (.75 * getValue());
        setValue(newValue);
        repaint();
        makeIntervalBetweenPulses();
    }

    private void makeIntervalBetweenPulses() {
        try { Thread.sleep(50); } 
        catch (Exception e) { e.printStackTrace(); };
    }

    @Override
    public void update(Observable subject) {
        setValue(MAX_VALUE);        
    }
}