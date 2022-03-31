package com.example.patterns.proxy.remote.machinemonitor.launchers;

import java.rmi.Naming;

import com.example.patterns.proxy.remote.machinemonitor.machine.*;

public class GumballMachineHCMCLauncher {
    public static void main(String[] args) {
        try {
            String location = "HCMC";
            RemoteGumballMachine machine = new GumballMachine(location, 100);
            Naming.rebind("//localhost/gumballmachine/" + location, machine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}