package com.example.patterns.compound.dj.models;

public final class Bpm extends AbstractObservable {
    public static final int DEFAULT_VALUE = 90;
    
    private int value;

    Bpm() { value = DEFAULT_VALUE; }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    void setValue(int value) {
        if (value <= 0) {
            try { throw new IllegalArgumentException("Bpm must be positive!"); } 
            catch (IllegalArgumentException e) { e.printStackTrace(); }
            this.value = 60;
        } else this.value = value;
        notifyObservers();
    }
}