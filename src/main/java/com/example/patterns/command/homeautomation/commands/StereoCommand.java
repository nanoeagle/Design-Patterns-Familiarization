package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.Stereo;

public abstract class StereoCommand implements Command {
    Stereo stereo;

    StereoCommand(Stereo stereo) throws IllegalArgumentException {
        if (stereo == null) 
            throw new IllegalArgumentException("Must specify the stereo.");
        this.stereo = stereo;
    }
}