package com.example.patterns.strategy.ducksimulator.ducks;

import com.example.patterns.strategy.ducksimulator.duckbehaviours.*;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}