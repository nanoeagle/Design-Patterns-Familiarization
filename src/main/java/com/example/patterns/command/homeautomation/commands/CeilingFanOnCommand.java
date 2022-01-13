package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.CeilingFan;

public class CeilingFanOnCommand extends CeilingFanCommand {
    public CeilingFanOnCommand(CeilingFan ceilingFan) 
    throws IllegalArgumentException {
        super(ceilingFan);
    }

    @Override
    public void execute() {
        setPrevPowerLvl();
        switch (prevPowerLvl) {
            case OFF: ceilingFan.toLowLevel(); return;
            case LOW: ceilingFan.toMediumLevel(); return;
            case MEDIUM: ceilingFan.toHighLevel(); return;
            case HIGH: ceilingFan.toLowLevel(); return;
        }
    }
}