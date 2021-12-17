package com.example.familiarization.strategypattern.duckbehaviours;

public class NotQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}