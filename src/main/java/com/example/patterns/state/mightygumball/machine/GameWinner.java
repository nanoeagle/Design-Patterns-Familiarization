package com.example.patterns.state.mightygumball.machine;

class GameWinner extends Sold {
    GameWinner(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    void dispense() {
        gumballMachine.releaseOneBall();
        if (gumballMachine.isOutOfGumballs()) doWhenOutOfGumballs();
        else {
            givePrize();
            transitionCurrentStateOfGumballMachine();
        }
    }

    private void givePrize() {
        gumballMachine.releaseOneBall();
        System.out.println("YOU'RE A WINNER! " 
            + "You got two gumballs for your quarter");
    }

    @Override
    public String toString() {
        return "despensing two gumballs for your quarter, " 
            + "because YOU'RE A WINNER!";
    }
}