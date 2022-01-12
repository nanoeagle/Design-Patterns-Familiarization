package com.example.patterns.command.homeautomation;

import java.util.*;

import com.example.patterns.command.homeautomation.commands.*;
import com.example.patterns.command.homeautomation.invokers.*;
import com.example.patterns.command.homeautomation.receivers.*;

/**
 * Act as a client.
 */
public class HomeAutomationDemo {
    private RemoteControl remoteControl = new RemoteControl();

    public static void main(String[] args) {
        HomeAutomationDemo demo = new HomeAutomationDemo();
        try {
            List<Command> commands = demo.createCommands();
            demo.setCommandsForRemoteControl(commands);
            System.out.println(demo.remoteControl);
            demo.pressButtonsOnRemoteControl();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private List<Command> createCommands() throws RuntimeException {
        List<Command> commands = new ArrayList<>();
        commands.add(new LightOnCommand(new Light("Living room")));
        commands.add(new LightOffCommand(new Light("Living room")));
        commands.add(new LightOnCommand(new Light("Kitchen")));
        commands.add(new LightOffCommand(new Light("Kitchen")));
        commands.add(new CeilingFanOnCommand(new CeilingFan("Living room")));
        commands.add(new CeilingFanOffCommand(new CeilingFan("Living room")));
        commands.add(new GarageDoorUpCommand(new GarageDoor("Garage")));
        commands.add(new GarageDoorDownCommand(new GarageDoor("Garage")));
        commands.add(new StereoOnWithCDCommand(new Stereo("Living Room")));
        commands.add(new StereoOffCommand(new Stereo("Living Room")));
        return commands;
    }

    private void setCommandsForRemoteControl(List<Command> cmds) {
        for (int slot = 0; slot < cmds.size()/2; slot++)
            remoteControl.setCommands(
                slot, cmds.get(2*slot), cmds.get(2*slot + 1));
    }

    private void pressButtonsOnRemoteControl() {
        for (int i = 0; i < RemoteControl.NUM_OF_SLOTS; i++) {
            remoteControl.pressOnButtonAt(i);
            remoteControl.pressOffButtonAt(i);
        }
    }
}