package com.example.patterns.state.mightygumball.machine;

abstract class State {
    GumballMachine gumballMachine;

    State(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    abstract void insertQuarter();
    abstract void ejectQuarter();
    abstract void turnCrank();
    abstract void dispense();

    void refillWith(int numberOfGumballs) {
        throw new UnsupportedOperationException(
            "Must not refill the machine when in state " 
                + getClass().getSimpleName());
    }
}