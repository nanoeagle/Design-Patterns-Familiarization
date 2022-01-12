package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.CeilingFan;

public class CeilingFanOffCommand extends CeilingFanCommand {
    public CeilingFanOffCommand(CeilingFan ceilingFan) 
    throws IllegalArgumentException {
        super(ceilingFan);
    }

    @Override
    public void execute() {
        ceilingFan.off();
    }
}