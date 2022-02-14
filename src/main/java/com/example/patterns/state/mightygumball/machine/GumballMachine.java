package com.example.patterns.state.mightygumball.machine;

public class GumballMachine {
    GumballMachineState soldOut;
    GumballMachineState noQuarter;
    GumballMachineState hasQuarter;
    GumballMachineState sold;
    GumballMachineState winner;
    private GumballMachineState currentState;
    private int availableGumballs;

    public GumballMachine(int numberOfGumballs) {
        setInternalStates();
        setInitialCurrentStateBasedOn(numberOfGumballs);
        availableGumballs = numberOfGumballs;
    }

    private void setInternalStates() {
        soldOut = new SoldOut(this);
        noQuarter = new NoQuarter(this);
        hasQuarter = new HasQuarter(this);
        sold = new Sold(this);
        winner = new GameWinner(this);
    }
    
    private void setInitialCurrentStateBasedOn(int numberOfGumballs) {
        if (numberOfGumballs < 0) throw new IllegalArgumentException(
            "the number of gumballs must not be negative.");
        if (numberOfGumballs == 0) currentState = soldOut;
        else currentState = noQuarter;
    }

    public int getAvailableGumballs() {
        return availableGumballs;
    }

    void setCurrentState(GumballMachineState currentState) {
        this.currentState = currentState;
    }    

    public void insertQuarter() {
        currentState.insertQuarter();
    }

    public void ejectQuarter() {
        currentState.ejectQuarter();
    }

    public void turnCrank() {
        currentState.turnCrank();
        if (currentState instanceof Sold) currentState.dispense();
    }    
    
    void releaseOneBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (availableGumballs > 0) availableGumballs -= 1;
    }

    public boolean isOutOfGumballs() {
        return availableGumballs == 0;
    }

    public void refillWith(int numberOfGumballs) {
        currentState.refillWith(numberOfGumballs);
        System.out.println("The machine has been refilled.");
    }

    void incrementAvailableGumballsBy(int numberOfGumballs) {
        if (numberOfGumballs <= 0) throw new IllegalArgumentException(
            "the number of gumballs to refilling must be positive.");
        availableGumballs += numberOfGumballs;
    }

    @Override
    public String toString() {
        return "\nMighty Gumball, Inc. \nInventory: " 
            + availableGumballs + " gumball" 
            + (availableGumballs > 1 ? "s " : " ")
            + "\nMachine is " + currentState + ".\n";
    }
}