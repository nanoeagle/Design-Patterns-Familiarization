package com.example.patterns.proxy.machinemonitor.monitor;

import java.rmi.RemoteException;

import com.example.patterns.proxy.machinemonitor.machine.RemoteGumballMachine;

public class GumballMachineMonitor {
    private RemoteGumballMachine machine;
    
    public GumballMachineMonitor(RemoteGumballMachine machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("\nGumball Machine: " + machine.getLocation());
            System.out.println("Current inventory: " 
                + machine.getAvailableGumballs() + " gumballs");
            System.out.println("Current state: " + machine.getCurrentState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}