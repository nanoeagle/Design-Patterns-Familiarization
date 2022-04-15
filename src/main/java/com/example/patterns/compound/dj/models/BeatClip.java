package com.example.patterns.compound.dj.models;

import java.io.File;

import javax.sound.sampled.*;

final class BeatClip extends AbstractObservable {
    private Clip clip;
    
    BeatClip() {
        try {
            File resource = new File("D:/Study/Practice/Design Patterns/Design-Patterns-Familiarization/src/main/resources/clap.wav");
            clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            clip.open(AudioSystem.getAudioInputStream(resource));
        } catch(Exception e) {
            System.out.println("Error: Can't load clip");
            e.printStackTrace();
        }
    }

    void play() {
        clip.setFramePosition(0);
        clip.start();
        notifyObservers();
    }

    void stop() {
        clip.setFramePosition(0);
        clip.stop();
    }
}