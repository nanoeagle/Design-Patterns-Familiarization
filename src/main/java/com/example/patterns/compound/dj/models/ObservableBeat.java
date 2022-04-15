package com.example.patterns.compound.dj.models;

import com.example.patterns.compound.dj.views.Observer;

public interface ObservableBeat {
    void setBpmValue(int bpm);
    int getBpmValue();
    void play();
    void stop();

    void registerBeatObserver(Observer obs);
    void registerBpmObserver(Observer obs);
    void removeBeatObserver(Observer obs);
    void removeBpmObserver(Observer obs);
}