package com.example.patterns.adapter.fowlsimulator.adapters;

import java.util.Random;

import com.example.patterns.adapter.fowlsimulator.fowl.*;

public class DuckToTurkeyAdapter implements Turkey {
    private Duck duck;
    private Random rand;
    
    public DuckToTurkeyAdapter(Duck duck) {
        this.duck = duck;
        rand = new Random();
    }
    
    @Override
    public void gobble() {
        duck.quack();
    }
    
    @Override
    public void fly() {
        if (rand.nextInt(5) == 0) duck.fly();
    }
}