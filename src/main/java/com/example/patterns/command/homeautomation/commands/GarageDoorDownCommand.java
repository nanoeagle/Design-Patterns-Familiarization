package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.GarageDoor;

public class GarageDoorDownCommand extends GarageDoorCommand {
	public GarageDoorDownCommand(GarageDoor garageDoor) 
	throws IllegalArgumentException {
		super(garageDoor);
	}

	@Override
	public void execute() {
		garageDoor.down();
	}

	@Override
    public void undo() {
        garageDoor.up();
    }
}