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

            demo.remoteControl.pressOnButtonAt(2);
            demo.remoteControl.pressOnButtonAt(2);
            demo.remoteControl.pressOnButtonAt(2);
            demo.remoteControl.pressOnButtonAt(2);
            demo.remoteControl.pressUndoButton();
            demo.remoteControl.pressUndoButton();
            demo.remoteControl.pressOffButtonAt(2);
            demo.remoteControl.pressUndoButton();
            demo.remoteControl.pressOnButtonAt(2);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private List<Command> createCommands() throws RuntimeException {
        Light livingRoomLight = new Light("Living room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan livingRoomCeilingFan = new CeilingFan("Living room");
        GarageDoor garageDoor = new GarageDoor("Garage");
        // Stereo livingRoomStereo = new Stereo("Living room");
        
        List<Command> commands = new ArrayList<>();
        commands.add(new LightOnCommand(livingRoomLight));
        commands.add(new LightOffCommand(livingRoomLight));
        commands.add(new LightOnCommand(kitchenLight));
        commands.add(new LightOffCommand(kitchenLight));
        commands.add(new CeilingFanOnCommand(livingRoomCeilingFan));
        commands.add(new CeilingFanOffCommand(livingRoomCeilingFan));
        commands.add(new GarageDoorUpCommand(garageDoor));
        commands.add(new GarageDoorDownCommand(garageDoor));
        // commands.add(new StereoOnWithCDCommand(livingRoomStereo));
        // commands.add(new StereoOffCommand(livingRoomStereo));
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