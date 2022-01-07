package com.example.patterns.singleton.chocolateboiler;

public class ChocolateBoiler {
    private volatile static ChocolateBoiler uniqueInstance;
    
    private boolean empty;
    private boolean boiled;
    
    public static ChocolateBoiler getInstance() {
        if (uniqueInstance == null) 
            synchronized (ChocolateBoiler.class) {
                if (uniqueInstance == null) 
                    uniqueInstance = new ChocolateBoiler();
            }
        return uniqueInstance;
    }

    private ChocolateBoiler() {
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