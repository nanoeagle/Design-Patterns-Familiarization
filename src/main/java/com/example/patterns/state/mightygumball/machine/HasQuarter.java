package com.example.patterns.state.mightygumball.machine;

import java.util.Random;

class HasQuarter extends State {
    private static final int NUMBER_OF_GUMBALLS_FOR_PRIZE = 1;
    private static final int WIN_RATE = 10;
    private static final int DEFAULT_WINNING_NUMBER = 0;

    private Random numberGenerator = new Random(System.currentTimeMillis());

    HasQuarter(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }
 
    @Override
    void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setCurrentState(gumballMachine.getNoQuarter());
    }
 
    @Override
    void turnCrank() {
        System.out.println("You turned...");
        if (gumballMachineHasEnoughGumballsForPrize() && hasWinner())
            gumballMachine.setCurrentState(gumballMachine.getWinner());
        else gumballMachine.setCurrentState(gumballMachine.getSold());
    }

    private boolean gumballMachineHasEnoughGumballsForPrize() {
        return gumballMachine.getAvailableGumballs() 
            > NUMBER_OF_GUMBALLS_FOR_PRIZE;
    }

    private boolean hasWinner() {
        return numberGenerator.nextInt(100/WIN_RATE) == DEFAULT_WINNING_NUMBER;
    }

    @Override
    void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public String toString() {
        return "waiting for a turn of the crank";
    }
}