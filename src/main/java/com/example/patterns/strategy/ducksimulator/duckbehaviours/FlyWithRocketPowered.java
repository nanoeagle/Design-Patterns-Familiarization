package com.example.patterns.strategy.ducksimulator.duckbehaviours;

public class FlyWithRocketPowered implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}