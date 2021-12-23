package com.example.patterns.strategy.ducksimulator.duckbehaviours;

public class NotQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}