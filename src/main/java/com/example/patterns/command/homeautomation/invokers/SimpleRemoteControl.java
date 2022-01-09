package com.example.patterns.command.homeautomation.invokers;

import com.example.patterns.command.homeautomation.commands.Command;

public class SimpleRemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void pressButton() {
        slot.execute();
    }
}