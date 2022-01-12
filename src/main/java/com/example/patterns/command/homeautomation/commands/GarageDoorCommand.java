package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.GarageDoor;

public abstract class GarageDoorCommand implements Command {
    GarageDoor garageDoor;

    GarageDoorCommand(GarageDoor garageDoor) throws IllegalArgumentException {
        if (garageDoor == null) 
            throw new IllegalArgumentException("Must specify the garage door.");
        this.garageDoor = garageDoor;
    }
}