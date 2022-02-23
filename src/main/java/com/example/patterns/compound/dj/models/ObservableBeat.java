package com.example.patterns.compound.dj.models;

import com.example.patterns.compound.dj.observers.*;

public interface ObservableBeat {
    void setBpm(int bpm);
    int getBpm();
    void play();
    void stop();

    void register(BpmObserver observer);
    void register(BeatObserver observer);
    void remove(BpmObserver observer);
    void remove(BeatObserver observer);
}