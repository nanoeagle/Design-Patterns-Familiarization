package com.example.patterns.proxy.machinemonitor.launchers;

import java.rmi.Naming;

import com.example.patterns.proxy.machinemonitor.machine.*;

public class GumballMachineBRVTLauncher {
    public static void main(String[] args) {
        try {
            String location = "BRVT";
            RemoteGumballMachine machine = new GumballMachine(location, 50);
            Naming.rebind("//localhost/gumballmachine/" + location, machine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}