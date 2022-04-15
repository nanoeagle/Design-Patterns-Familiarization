package com.example.patterns.compound.dj.views;

import javax.swing.JLabel;

import com.example.patterns.compound.dj.models.*;

class BpmOutputLabel extends JLabel implements Observer {
    BpmOutputLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    @Override
    public void update(Observable subject) {
        setText("Current BPM: " + (Bpm) subject);
    }
}