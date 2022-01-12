package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.CeilingFan;

public class CeilingFanOnCommand extends CeilingFanCommand {
    public CeilingFanOnCommand(CeilingFan ceilingFan) 
    throws IllegalArgumentException {
        super(ceilingFan);
    }

    @Override
    public void execute() {
        ceilingFan.toHighLevel();
    }
}