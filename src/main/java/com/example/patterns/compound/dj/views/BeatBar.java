package com.example.patterns.compound.dj.views;

import javax.swing.*;

public class BeatBar extends JProgressBar implements Runnable {
    public static final int MAX_VALUE = 100;

    private static final long serialVersionUID = 2L;

    private boolean isOn;

    public BeatBar() {
        setMinimum(0);
        setMaximum(MAX_VALUE);
    }

    public void on() {
        isOn = true;
        Thread pulseThread = new Thread(this);
        pulseThread.start();
    }

    @Override
    public void run() { while (isOn) visualizePulse(); }

    public void off() {
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
}