package com.example.patterns.facade.hometheater;

import com.example.patterns.facade.hometheater.components.*;

public class HomeTheaterDemo {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier("Amplifier");
        StreamingPlayer player = new StreamingPlayer("Streaming Player");
        Projector projector = new Projector("Projector");
        Screen screen = new Screen("Theater Screen");
        TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
        PopcornPopper popper = new PopcornPopper("Popcorn Popper");
 
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
            amp, player, projector, screen, lights, popper);

        homeTheater.watchMovie("1917");
        homeTheater.endMovie();
    }
}