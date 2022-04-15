package com.example.patterns.compound.dj.views;

import com.example.patterns.compound.dj.models.Observable;

@FunctionalInterface
public interface Observer {
    void update(Observable subject);
}