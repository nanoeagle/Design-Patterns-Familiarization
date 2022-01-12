package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.Stereo;

public class StereoOnWithCDCommand extends StereoCommand {
    public StereoOnWithCDCommand(Stereo stereo) 
    throws IllegalArgumentException {
        super(stereo);
    }

    @Override
    public void execute() {
        stereo.on();
		stereo.setCD();
		stereo.setVolume(11);
    }
}