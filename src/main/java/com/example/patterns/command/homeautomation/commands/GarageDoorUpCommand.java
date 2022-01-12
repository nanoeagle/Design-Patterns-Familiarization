package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.GarageDoor;

public class GarageDoorUpCommand extends GarageDoorCommand {
    public GarageDoorUpCommand(GarageDoor garageDoor) 
    throws IllegalArgumentException {
        super(garageDoor);
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}