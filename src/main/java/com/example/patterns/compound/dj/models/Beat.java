package com.example.patterns.compound.dj.models;

import com.example.patterns.compound.dj.views.Observer;

public class Beat implements Runnable, ObservableBeat {    
    private Bpm bpm;
    private boolean play;
    private BeatClip beatClip;
    private Thread beatOnThread;

    public Beat() {
        bpm = new Bpm();
        beatClip = new BeatClip();
        beatOnThread = new Thread(this);
    }

    @Override
    public void setBpmValue(int value) {
        bpm.setValue(value);
        beatOnThread.interrupt();
    }

    @Override
    public int getBpmValue() {
        return bpm.getValue();
    }

    @Override
    public void play() {
        bpm.setValue(Bpm.DEFAULT_VALUE);
        play = true;
        beatOnThread.start();
    }

    @Override
    public void run() {
        while (play) {
            beatClip.play();
            makeIntervalBetweenBeats();
        }
    }

    private void makeIntervalBetweenBeats() {
        try { 
            int interval = 60000 / bpm.getValue();
            Thread.sleep(interval); 
        } catch (Exception e) { 
            System.err.println("beatOnThread: " + e.getMessage() + " - OK"); 
        }
    }

    @Override
    public void stop() {
        play = false;
        beatClip.stop();
    }
    
    @Override
    public void registerBeatObserver(Observer obs) {
        beatClip.register(obs);
    }

    @Override
    public void registerBpmObserver(Observer obs) {
        bpm.register(obs);        
    }

    @Override
    public void removeBeatObserver(Observer obs) {
        beatClip.remove(obs);
    }

    @Override
    public void removeBpmObserver(Observer obs) {
        bpm.remove(obs);   
    }
}