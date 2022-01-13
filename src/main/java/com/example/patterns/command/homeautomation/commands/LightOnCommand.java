package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.Light;

public class LightOnCommand extends LightCommand {
    public LightOnCommand(Light light) throws IllegalArgumentException {
        super(light);
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}