package com.example.familiarization.strategypattern.duckbehaviours;

public class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack");
    }
}