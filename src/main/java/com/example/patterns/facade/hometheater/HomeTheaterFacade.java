package com.example.patterns.facade.hometheater;

import com.example.patterns.facade.hometheater.components.*;

public class HomeTheaterFacade {
    private Amplifier amp;
    private StreamingPlayer player;
    private Projector projector;
    private Screen screen;
    private TheaterLights lights;
    private PopcornPopper popcornPopper;
    
    public HomeTheaterFacade(Amplifier amp, StreamingPlayer player, 
        Projector projector, Screen screen, TheaterLights lights, 
        PopcornPopper popcornPopper) 
    {
        this.amp = amp;
        this.player = player;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
        this.popcornPopper = popcornPopper;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popcornPopper.on();
        popcornPopper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setSurroundSound();
        amp.setVolume(5);
        player.on();
        player.play(movie);
    }

    public void endMovie() {
        System.out.println("\nShutting movie theater down...");
        popcornPopper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        player.stop();
        player.off();
    }
}