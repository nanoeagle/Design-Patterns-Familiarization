package com.example.patterns.command.homeautomation.invokers;

import com.example.patterns.command.homeautomation.commands.*;

public class RemoteControl {
    public static final int NUM_OF_SLOTS = 7;

    private Command[] onCommands;
    private Command[] offCommands;
    
    public RemoteControl() {
        onCommands = new Command[NUM_OF_SLOTS];
        offCommands = new Command[NUM_OF_SLOTS];
        Command noCommand = new NoCommand();
        for (int i = 0; i < NUM_OF_SLOTS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }
    
    public void setCommands(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }
    
    public void pressOnButtonAt(int slot) {
        onCommands[slot].execute();
    }
    
    public void pressOffButtonAt(int slot) {
        offCommands[slot].execute();
    }
    
    @Override
    public String toString() {
        String info = "\n------ Remote Control -------\n";
        for (int i = 0; i < NUM_OF_SLOTS; i++) 
            info += "[slot " + i + "] " 
                + onCommands[i].getClass().getSimpleName() + " " 
                + offCommands[i].getClass().getSimpleName() + "\n";
        return info;
    }
}