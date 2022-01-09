package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.Light;

public class LightOnCommand implements Command {
    private Light light;
 
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}