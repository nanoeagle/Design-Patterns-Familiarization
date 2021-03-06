package com.example.patterns.state.mightygumball.machine;

class SoldOut extends GumballMachineState {
    SoldOut(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }
 
    @Override
    void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }
 
    @Override
    void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }
 
    @Override
    void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    void refillWith(int numberOfGumballs) {
        gumballMachine.incrementAvailableGumballsBy(numberOfGumballs);
        gumballMachine.setCurrentState(gumballMachine.noQuarter);
    }

    @Override
    public String toString() {
        return "empty of gumballs";
    }
}