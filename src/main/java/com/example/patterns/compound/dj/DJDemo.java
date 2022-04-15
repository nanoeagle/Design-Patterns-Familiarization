package com.example.patterns.compound.dj;

import com.example.patterns.compound.dj.controllers.BeatController;
import com.example.patterns.compound.dj.models.Beat;

class DJDemo {
    public static void main(String[] args) {
        new BeatController(new Beat());
    }
}