package com.example.patterns.proxy.machinemonitor.machine;

class Sold extends GumballMachineState {
    private static final long serialVersionUID = 1L;

	Sold(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }
 
    @Override
    void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }
 
    @Override
    void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }
 
    @Override
    void dispense() {
        gumballMachine.releaseOneBall();
        transitionCurrentStateOfGumballMachine();
    }

    void transitionCurrentStateOfGumballMachine() {
        if (gumballMachine.isOutOfGumballs()) doWhenOutOfGumballs();
        else gumballMachine.setCurrentState(gumballMachine.noQuarter);
    }

    void doWhenOutOfGumballs() {
        System.out.println("Oops, out of gumballs!");
        gumballMachine.setCurrentState(gumballMachine.soldOut);
    }

    @Override
    public String toString() {
        return "dispensing a gumball";
    }
}