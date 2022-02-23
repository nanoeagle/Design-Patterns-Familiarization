package com.example.patterns.compound.dj.controllers;

import com.example.patterns.compound.dj.models.ObservableBeat;
import com.example.patterns.compound.dj.observers.*;
import com.example.patterns.compound.dj.views.*;

public class BeatController 
implements DJController, BeatObserver, BpmObserver {
    private ObservableBeat beat;
    private BeatView beatView;
    private ControlsView controlsView;
   
    public BeatController(ObservableBeat beat) {
        this.beat = beat;
        registerBeatObservers();
        beatView = new BeatView(this);
        controlsView = new ControlsView(this);
        setControlsViewComponentsWhenStop();
    }
    
    private void setControlsViewComponentsWhenStop() {
        controlsView.disableStopMenuItem();
        controlsView.enableStartMenuItem();
        controlsView.disableSetBpmBtn();
        controlsView.disableIncreaseBpmBtn();
        controlsView.disableDecreaseBpmBtn();
    }

    private void registerBeatObservers() {
        beat.register((BeatObserver) this);
        beat.register((BpmObserver) this);
    }

    @Override
    public void setBpm() {
        int bpm = controlsView.getBpmInputValue();
        beat.setBpm(bpm);
    }

    @Override
    public void play() {
        beat.play();
        beatView.turnOnBeatBar();
        setControlsViewComponentsWhenStart();
    }
  
    private void setControlsViewComponentsWhenStart() {
        controlsView.disableStartMenuItem();
        controlsView.enableStopMenuItem();
        controlsView.enableSetBpmBtn();
        controlsView.enableIncreaseBpmBtn();
        controlsView.enableDecreaseBpmBtn();
    }

    @Override
    public void stop() {
        beat.stop();
        beatView.turnOffBeatBar();
        beatView.setBpmOutputLabelValue("offline");
        setControlsViewComponentsWhenStop();
    }
    
    @Override
    public void increaseBpm() {
        int currentBpm = beat.getBpm();
        beat.setBpm(currentBpm + 1);
    }
    
    @Override
    public void decreaseBpm() {
        int currentBpm = beat.getBpm();
        beat.setBpm(currentBpm - 1);
    }

    @Override
    public void updateBeat() {
        beatView.setBeatBarValue(BeatBar.MAX_VALUE);
    }

    @Override
    public void updateBpm() {
        beatView.setBpmOutputLabelValue("Current BPM: " + beat.getBpm());
    }
}