package com.example.patterns.strategy.ducksimulator.duckbehaviours;

public class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("Squeak");
    }
}