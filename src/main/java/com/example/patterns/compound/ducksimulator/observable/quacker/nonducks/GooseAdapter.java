package com.example.patterns.compound.ducksimulator.observable.quacker.nonducks;

/* Adapter pattern. */
public class GooseAdapter extends NonDuck {
    private Goose goose;
    
    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }
    
    @Override
    public void quack() {
        goose.honk();
        notifyObservers();
    }
}