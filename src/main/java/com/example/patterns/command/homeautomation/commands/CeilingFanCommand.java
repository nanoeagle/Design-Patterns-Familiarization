package com.example.patterns.command.homeautomation.commands;

import com.example.patterns.command.homeautomation.receivers.CeilingFan;
import com.example.patterns.command.homeautomation.receivers.CeilingFan.PowerLevel;

public abstract class CeilingFanCommand implements Command {
    CeilingFan ceilingFan;
    PowerLevel prevPowerLvl;

    CeilingFanCommand(CeilingFan ceilingFan) throws IllegalArgumentException {
        if (ceilingFan == null) 
            throw new IllegalArgumentException("Must specify the ceiling fan.");
        this.ceilingFan = ceilingFan;
    }

    void setPrevPowerLvl() {
        prevPowerLvl = ceilingFan.getPowerLevel();
    }

    @Override
    public void undo() {
        if (prevPowerLvl == null) 
            throw new NullPointerException("Previous power level of the fan is null.");
        switch (prevPowerLvl) {
            case OFF: ceilingFan.off(); return;
            case LOW: ceilingFan.toLowLevel(); return;
            case MEDIUM: ceilingFan.toMediumLevel(); return;
            case HIGH: ceilingFan.toHighLevel(); return;
        }
    }
}