package com.example.familiarization.strategypattern.duckbehaviours;

public class FlyWithRocketPowered implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}