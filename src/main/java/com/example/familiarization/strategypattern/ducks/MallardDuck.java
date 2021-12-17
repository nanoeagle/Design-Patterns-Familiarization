package com.example.familiarization.strategypattern.ducks;

import com.example.familiarization.strategypattern.duckbehaviours.*;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}