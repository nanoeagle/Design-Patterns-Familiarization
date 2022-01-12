package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.Stereo;

public class StereoOffCommand extends StereoCommand {
    public StereoOffCommand(Stereo stereo) throws IllegalArgumentException {
        super(stereo);
    }

    @Override
    public void execute() {
        stereo.off();
    }
}