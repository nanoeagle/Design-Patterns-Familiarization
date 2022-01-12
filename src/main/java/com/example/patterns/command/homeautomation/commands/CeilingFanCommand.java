package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.CeilingFan;

public abstract class CeilingFanCommand implements Command {
    CeilingFan ceilingFan;

    CeilingFanCommand(CeilingFan ceilingFan) throws IllegalArgumentException {
        if (ceilingFan == null) 
            throw new IllegalArgumentException("Must specify the ceiling fan.");
        this.ceilingFan = ceilingFan;
    }
}