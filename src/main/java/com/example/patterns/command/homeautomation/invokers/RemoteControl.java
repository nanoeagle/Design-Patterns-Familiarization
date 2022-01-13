package com.example.patterns.command.homeautomation.invokers;

import com.example.patterns.command.homeautomation.commands.*;

public class RemoteControl {
    public static final int NUM_OF_SLOTS = 7;

    private Command[] onCommands;
    private Command[] offCommands;
    private Command lastInvokedCommand;
    
    public RemoteControl() {
        onCommands = new Command[NUM_OF_SLOTS];
        offCommands = new Command[NUM_OF_SLOTS];
        Command noCommand = new NoCommand();
        lastInvokedCommand = noCommand;
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
        lastInvokedCommand = onCommands[slot];
    }
    
    public void pressOffButtonAt(int slot) {
        offCommands[slot].execute();
        lastInvokedCommand = offCommands[slot];
    }

    public void pressUndoButton() {
        lastInvokedCommand.undo();
    }
    
    @Override
    public String toString() {
        String info = "\n------ Remote Control -------\n";
        for (int i = 0; i < NUM_OF_SLOTS; i++) 
            info += "[slot " + i + "] " 
                + onCommands[i].getClass().getSimpleName() + " " 
                + offCommands[i].getClass().getSimpleName() + "\n";
        info += "Last invoked command: " 
            + lastInvokedCommand.getClass().getSimpleName() + "\n";
        return info;
    }
}