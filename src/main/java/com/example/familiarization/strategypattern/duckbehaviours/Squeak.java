package com.example.familiarization.strategypattern.duckbehaviours;

public class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("Squeak");
    }
}