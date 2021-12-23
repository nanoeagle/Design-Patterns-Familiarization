package com.example.patterns.strategy.ducksimulator.duckbehaviours;

public class NotFly implements FlyBehavior {
    public void fly() {
        System.out.println("I can't fly");
    }
}