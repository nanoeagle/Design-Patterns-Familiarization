package com.example.patterns.strategy.ducksimulator.duckbehaviours;

public class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack");
    }
}