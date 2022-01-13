package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.Light;

public class LightOffCommand extends LightCommand {
    public LightOffCommand(Light light) throws IllegalArgumentException {
        super(light);
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}