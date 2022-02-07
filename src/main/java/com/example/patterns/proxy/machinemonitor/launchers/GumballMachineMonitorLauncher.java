package com.example.patterns.proxy.machinemonitor.launchers;

import java.rmi.Naming;

import com.example.patterns.proxy.machinemonitor.machine.RemoteGumballMachine;
import com.example.patterns.proxy.machinemonitor.monitor.GumballMachineMonitor;

public class GumballMachineMonitorLauncher {
    public static void main(String[] args) {
        GumballMachineMonitorLauncher launcher = new GumballMachineMonitorLauncher();
        try {
            launcher.report("HCMC");
            launcher.report("BRVT");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void report(String location) throws Exception {
        RemoteGumballMachine machine = (RemoteGumballMachine) 
            Naming.lookup("rmi://localhost/gumballmachine/" + location);
        GumballMachineMonitor monitor = new GumballMachineMonitor(machine);
        monitor.report();
    }
}