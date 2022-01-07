package com.example.patterns.singleton.chocolateboiler;

public enum ChocoBoiler {
    INSTANCE;

    private boolean empty;
    private boolean boiled;

    private ChocoBoiler() {
        empty = true;
        boiled = false;
    }

    public void fill() {
        if (empty) {
            empty = false;
            boiled = false;
            // fill the boiler with a milk/chocolate mixture
        }
    }

    public void drain() {
        if (!empty && boiled) {
            // drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil() {
        if (!empty && !boiled) {
            // bring the contents to a boil
            boiled = true;
        }
    }
        
    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}