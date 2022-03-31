package com.example.patterns.proxy.remote.machinemonitor.machine;

import java.rmi.*;

public interface RemoteGumballMachine extends Remote {
    GumballMachineState getCurrentState() throws RemoteException;
    String getLocation() throws RemoteException;
    int getAvailableGumballs() throws RemoteException;
}