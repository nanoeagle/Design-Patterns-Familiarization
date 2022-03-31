package com.example.patterns.proxy.remote.machinemonitor.machine;

import java.io.Serializable;

public abstract class GumballMachineState implements Serializable {
    private static final long serialVersionUID = 1L;

    transient GumballMachine gumballMachine;

    GumballMachineState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    abstract void insertQuarter();
    abstract void ejectQuarter();
    abstract void turnCrank();
    abstract void dispense();

    void refillWith(int numberOfGumballs) throws UnsupportedOperationException {
        throw new UnsupportedOperationException(
            "Must not refill the machine when in state " 
                + getClass().getSimpleName());
    }
}