package com.example.patterns.compound.dj.controllers;

import com.example.patterns.compound.dj.models.ObservableBeat;
import com.example.patterns.compound.dj.views.*;

public class BeatController implements DJController {
    private ObservableBeat beat;
    private BeatView beatView;
    private ControlsView controlsView;
   
    public BeatController(ObservableBeat beat) {
        this.beat = beat;
        beatView = new BeatView();
        controlsView = new ControlsView(this);
        beat.registerBeatObserver(beatView.getBeatObserver());
        beat.registerBpmObserver(beatView.getBpmObserver());
        setControlsViewComponentsWhenStop();
    }
    
    private void setControlsViewComponentsWhenStop() {
        controlsView.disableStopMenuItem();
        controlsView.enableStartMenuItem();
        controlsView.disableSetBpmBtn();
        controlsView.disableIncreaseBpmBtn();
        controlsView.disableDecreaseBpmBtn();
    }

    @Override
    public void setBpm() {
        int bpm = controlsView.getBpmInputValue();
        beat.setBpmValue(bpm);
    }

    @Override
    public void play() {
        beat.play();
        beatView.turnOn();
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
        beatView.turnOff();
        setControlsViewComponentsWhenStop();
    }
    
    @Override
    public void increaseBpm() { incrementBpmBy(1); }

    @Override
    public void decreaseBpm() { incrementBpmBy(-1); }

    private void incrementBpmBy(int i) {
        int currentBpm = beat.getBpmValue();
        beat.setBpmValue(currentBpm + i);
    }
}