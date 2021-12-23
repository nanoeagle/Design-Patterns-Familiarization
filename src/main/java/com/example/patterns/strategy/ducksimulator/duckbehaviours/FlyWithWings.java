package com.example.patterns.strategy.ducksimulator.duckbehaviours;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}