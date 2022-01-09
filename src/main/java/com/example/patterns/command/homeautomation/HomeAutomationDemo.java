package com.example.patterns.command.homeautomation;

import com.example.patterns.command.homeautomation.commands.*;
import com.example.patterns.command.homeautomation.invokers.SimpleRemoteControl;
import com.example.patterns.command.homeautomation.receivers.*;

public class HomeAutomationDemo {
    public static void main(String[] args) {
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        
        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorOpenCommand garageOpen = 
            new GarageDoorOpenCommand(garageDoor);
        
        SimpleRemoteControl remote = new SimpleRemoteControl();
        remote.setCommand(lightOn);
        remote.pressButton();
        
        remote.setCommand(garageOpen);
        remote.pressButton();
    }
}