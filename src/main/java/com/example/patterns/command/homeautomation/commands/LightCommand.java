package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.Light;

public abstract class LightCommand implements Command {
    Light light;

    LightCommand(Light light) throws IllegalArgumentException {
        if (light == null) 
            throw new IllegalArgumentException("Must specify the light.");
        this.light = light;
    }
}