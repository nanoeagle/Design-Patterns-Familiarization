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

            System.out.println("\n------ Undo button -------");
            demo.remoteControl.pressOnButtonAt(2);
            demo.remoteControl.pressOnButtonAt(2);
            demo.remoteControl.pressOnButtonAt(2);
            demo.remoteControl.pressOnButtonAt(2);
            demo.remoteControl.pressUndoButton();

            System.out.println("\n------ Party Macro On -------");
            demo.remoteControl.pressOnButtonAt(4);
            System.out.println("\n------ Party Macro Off -------");
            demo.remoteControl.pressOffButtonAt(4);
            System.out.println("\n------ Undo Party Macro -------");
            demo.remoteControl.pressUndoButton();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private List<Command> createCommands() throws RuntimeException {
        Light livingRoomLight = new Light("Living room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan livingRoomCeilingFan = new CeilingFan("Living room");
        GarageDoor garageDoor = new GarageDoor("Garage");
        
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command livingRoomCeilingFanOn = new CeilingFanOnCommand(livingRoomCeilingFan);
        Command livingRoomCeilingFanOff = new CeilingFanOffCommand(livingRoomCeilingFan);
        Command garageDoorUp = new GarageDoorUpCommand(garageDoor);
        Command garageDoorDown = new GarageDoorDownCommand(garageDoor);
        Command[] partyStartCommands = {livingRoomLightOn, 
            livingRoomCeilingFanOn, garageDoorUp};
        Command[] partyEndCommands = {livingRoomLightOff, 
            livingRoomCeilingFanOff, garageDoorDown};

        List<Command> commands = new ArrayList<>();
        commands.add(livingRoomLightOn);
        commands.add(livingRoomLightOff);
        commands.add(new LightOnCommand(kitchenLight));
        commands.add(new LightOffCommand(kitchenLight));
        commands.add(livingRoomCeilingFanOn);
        commands.add(livingRoomCeilingFanOff);
        commands.add(garageDoorUp);
        commands.add(garageDoorDown);
        commands.add(new MacroCommand(partyStartCommands));
        commands.add(new MacroCommand(partyEndCommands));
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