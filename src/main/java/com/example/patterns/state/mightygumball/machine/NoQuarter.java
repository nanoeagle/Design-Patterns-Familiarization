package com.example.patterns.state.mightygumball.machine;

class NoQuarter extends State {
    NoQuarter(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setCurrentState(gumballMachine.getHasQuarter());
    }

    @Override
    void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    void turnCrank() {
        System.out.println("You turned, but there's no quarter");
    }

    @Override
    void dispense() {
        System.out.println("You need to pay first");
    }

    @Override
    void refillWith(int numberOfGumballs) {
        gumballMachine.incrementAvailableGumballsBy(numberOfGumballs);
    }

    @Override
    public String toString() {
        return "waiting for a quarter";
    }
}