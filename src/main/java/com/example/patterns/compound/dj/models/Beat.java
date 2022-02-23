package com.example.patterns.compound.dj.models;

import java.io.File;
import java.util.*;

import javax.sound.sampled.*;

import com.example.patterns.compound.dj.observers.*;

public class Beat implements Runnable, ObservableBeat {
    private int bpm = 90;
    private boolean play;
    private BeatClip beatClip = new BeatClip();
    private List<BpmObserver> bpmObservers = new ArrayList<>();
    private List<BeatObserver> beatObservers = new ArrayList<>();

    public Beat() {
        beatClip.initialize();
    }

    @Override
    public void setBpm(int bpm) {
        this.bpm = bpm;
        notifyBpmObservers();
    }

    @Override
    public int getBpm() {
        return bpm;
    }

    @Override
    public void play() {
        bpm = 90;
        notifyBpmObservers();
        play = true;
        Thread beatOnThread = new Thread(this);
        beatOnThread.start();
    }

    private void notifyBpmObservers() {
        for (BpmObserver observer : bpmObservers) observer.updateBpm();
    }

    @Override
    public void run() {
        while (play) {
            beatClip.play();
            notifyBeatObservers();
            makeIntervalBetweenBeats();
        }
    }
    
    private void notifyBeatObservers() {
        for (BeatObserver observer : beatObservers) observer.updateBeat();
    }

    private void makeIntervalBetweenBeats() {
        try { 
            int interval = 60000 / bpm;
            Thread.sleep(interval); 
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void stop() {
        beatClip.stop();
        play = false;
    }

    @Override
    public void register(BpmObserver observer) {
        bpmObservers.add(observer);
    }

    @Override
    public void register(BeatObserver observer) {
        beatObservers.add(observer);
    }

    @Override
    public void remove(BpmObserver observer) {
        bpmObservers.remove(observer);
    }

    @Override
    public void remove(BeatObserver observer) {
        beatObservers.remove(observer);
    }

    private final class BeatClip {
        private Clip clip;

        private void initialize() {
            try {
                File resource = new File("address in your file system/clap.wav");
                clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
                clip.open(AudioSystem.getAudioInputStream(resource));
            } catch(Exception e) {
                System.out.println("Error: Can't load clip");
                e.printStackTrace();
            }
        }
        
        private void play() {
            clip.setFramePosition(0);
            clip.start();
        }

        private void stop() {
            clip.setFramePosition(0);
            clip.stop();
        }
    }
}