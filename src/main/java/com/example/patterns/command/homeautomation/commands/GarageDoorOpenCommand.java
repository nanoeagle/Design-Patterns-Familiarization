package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.GarageDoor;

public class GarageDoorOpenCommand implements Command {
    private GarageDoor garageDoor;
 
    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}