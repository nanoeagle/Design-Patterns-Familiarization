package com.example.patterns.command.homeautomation.commands;

public interface Command {
    void execute();
    void undo();
}